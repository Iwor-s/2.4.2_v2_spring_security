package web.config;

import org.springframework.stereotype.Component;
import web.models.User;
import web.services.UserService;

import javax.annotation.PostConstruct;

@Component
public class DBinit {
    
    private final UserService userService;
    
    public DBinit(UserService service) {
        this.userService = service;
    }
    
    @PostConstruct
    public void createData() {
        for (int i = 1; i < 11; i++) {
            User user = new User("name-" + i, "surname-" + i, 2000 + i);
            userService.saveUser(user);
        }
    }
}
