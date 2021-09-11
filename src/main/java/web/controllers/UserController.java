package web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    
    @GetMapping("user")
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello USER!");
        model.addAttribute("messages", messages);
        return "user";
    }
    
    @GetMapping("login")
    public String loginPage() {
        return "login";
    }
}