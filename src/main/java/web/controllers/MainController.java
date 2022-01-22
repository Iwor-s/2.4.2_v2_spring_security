package web.controllers;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import web.models.User;

import java.security.Principal;

@Controller
public class MainController {
    UserDetailsService userDetailsService;
    
    public MainController(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
    
    @GetMapping("admin")
    public String adminPage() {
        return "redirect:admin/users";
    }
    
    @GetMapping("user")
    public String printWelcome(Model model, Principal principal) {
        User user = (User) userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", user);
        return "user";
    }
    
    @GetMapping("login")
    public String loginPage() {
        return "login";
    }
}
