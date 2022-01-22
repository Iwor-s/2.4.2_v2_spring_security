package web.config;

import org.springframework.stereotype.Component;
import web.models.Role;
import web.models.User;
import web.services.RoleService;
import web.services.UserService;

import javax.annotation.PostConstruct;

@Component
public class DBinit {
    private final RoleService roleService;
    private final UserService userService;
    
    public DBinit(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }
    
    @PostConstruct
    public void createData() {
        roleService.save(new Role("ADMIN"));
        roleService.save(new Role("USER"));
        
        User user1 = new User();
        user1.setLogin("том");
        user1.setPassword("$2a$12$a7vk0btxFWdqKfwVvVMWkOCZN0NTNLjSee2r1rn6bO5Wwsgvc6CsK");
        user1.setName("Tom");
        user1.setSurname("Jones");
        user1.setEmail("tom@gmail.com");
        user1.setEnabled(true);
        
        User user2 = new User();
        user2.setLogin("анна");
        user2.setPassword("$2a$12$Wy.Jun3.k2ygVibBOzrKn.Yei3S4JI.04klh0W9r.0wzgda6bs3bS");
        user2.setName("Ann");
        user2.setSurname("Smith");
        user2.setEmail("ann@hotmail.com");
        user2.setEnabled(true);
        
        User user3 = new User();
        user3.setLogin("sam");
        user3.setPassword("$2a$12$536R8BLn229MVhiShjzfFe4VQ0mik6dRXaT6FP2aSMsOoRs6NC3i6");
        user3.setName("Sam");
        user3.setSurname("Black");
        user3.setEmail("sam@yahoo.com");
        user3.setEnabled(true);
    
        user1.addRole(roleService.getByName("ADMIN"));
        user2.addRole(roleService.getByName("USER"));
        user3.addRole(roleService.getByName("ADMIN"));
        user3.addRole(roleService.getByName("USER"));
        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
    }
}
