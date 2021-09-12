package web.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import web.models.User;
import web.services.UserService;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    
    UserDetailsService userDetailsService;
    
    public MainController(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
    
    @GetMapping("admin")
    public String amdinPage() {
        return "redirect:admin/users";
    }
    
    @GetMapping("user")
    public String printWelcome(Model model, Principal principal) {
        User user = (User) userDetailsService.loadUserByUsername(principal.getName());
        System.out.println(user);
        model.addAttribute("user", user);
        return "user";
    }
    
    @GetMapping("login")
    public String loginPage() {
        return "login";
    }
    
}