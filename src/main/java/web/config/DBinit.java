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
        Role role1 = new Role("ADMIN");
        Role role2 = new Role("USER");
        roleService.save(role1);
        roleService.save(role2);
        
        for (int i = 1; i < 11; i++) {
            User user = new User("name-" + i, "surname-" + i, 2000 + i);
            if (i % 5 == 0) {
                user.setRole(role1);
            }
            user.setRole(role2);
            userService.save(user);
        }
    }
}
