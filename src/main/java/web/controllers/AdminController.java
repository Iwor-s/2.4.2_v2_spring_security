package web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.models.User;
import web.services.RoleService;
import web.services.UserService;


@Controller
@RequestMapping("admin/users")
public class AdminController {
    private final RoleService roleService;
    private final UserService userService;
    
    public AdminController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }
    
    @GetMapping
    public String showAll(Model model) {
        model.addAttribute("users", userService.getAll());
        return "users/users";
    }
    
    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "users/new";
    }
    
    @PostMapping
    public String create(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/users";
    }
    
    @GetMapping("/{id}/edit")
    public String edit(Model model,
                       @PathVariable("id") long id) {
        model.addAttribute("user", userService.getById(id));
        model.addAttribute("roles", roleService.getAll());
        return "users/edit";
    }
    
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/users";
    }
    
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.deleteById(id);
        return "redirect:/users";
    }
}
