package web.config;

import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

import web.models.Role;
import web.models.User;
import web.services.RoleService;
import web.services.UserService;

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
        
        User user1 = new User("tom", "tom", "Tom", "Jones", "tom@gmail.com");
        User user2 = new User("ann", "ann", "Ann", "Smith", "ann@hotmail.com");
        User user3 = new User("sam", "sam", "Sam", "Black", "sam@yahoo.com");
        user1.addRole(roleService.getByName("ADMIN"));
        user2.addRole(roleService.getByName("USER"));
        user3.addRole(roleService.getByName("ADMIN"));
        user3.addRole(roleService.getByName("USER"));
        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
    }
}
