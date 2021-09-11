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
        
        User user1 = new User("tom", "tom");
        User user2 = new User("ann", "ann");
        User user3 = new User("sam", "sam");
        user1.addRole(role1);
        user2.addRole(role2);
        user3.addRole(role1);
        user3.addRole(role2);
        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
    }
}
