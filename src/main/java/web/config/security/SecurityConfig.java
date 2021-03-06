package web.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.CharacterEncodingFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;
    private final LoginSuccessHandler loginSuccessHandler;
    
    public SecurityConfig(UserDetailsService userDetailsService
            , LoginSuccessHandler loginSuccessHandler) {
        this.userDetailsService = userDetailsService;
        this.loginSuccessHandler = loginSuccessHandler;
    }
    
    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/login")                    // указываем страницу с формой логина
                .successHandler(loginSuccessHandler)    //указываем логику обработки при логине
                // .loginProcessingUrl("/login")           // указываем action с формы логина
                .usernameParameter("j_username")        // Указываем параметры логина и пароля с формы логина
                .passwordParameter("j_password")
                .permitAll();                           // даем доступ к форме логина всем

        http.logout()
                .permitAll()                            // разрешаем делать логаут всем
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // указываем URL логаута
                .logoutSuccessUrl("/login?logout")      // указываем URL при удачном логауте
                .and().csrf().disable();                //выклчаем кроссдоменную секьюрность (на этапе обучения неважна)
    
        http
                .authorizeRequests()                    // делаем страницу регистрации недоступной для авторизированных пользователей
                .antMatchers("/login").anonymous()  //страница аутентификации доступна только анонимам
                .antMatchers("/static/**").permitAll()  // for css in login.html page
                .antMatchers("/admin/**").access("hasRole('ADMIN')")
                .antMatchers("/user/**").access("hasAnyRole('USER', 'ADMIN')")
                .antMatchers("/").authenticated()
                // .anyRequest().authenticated()
        ;
    
        http.addFilterBefore(characterEncodingFilter(), CsrfFilter.class);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
// Remove the ROLE_ prefix
    @Bean
    public GrantedAuthorityDefaults grantedAuthorityDefaults() {
        return new GrantedAuthorityDefaults("");
    }
    
// for cyrillic password
    private CharacterEncodingFilter characterEncodingFilter() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        return filter;
    }
}
