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
    
    // @GetMapping
    // public String showUsers(Model model) {
    //     return "redirect:admin/users";
    // }
    
    @GetMapping
    public String showAll(Model model) {
        model.addAttribute("users", userService.getAll());
        return "admin/users";
    }
    
    @GetMapping("new")
    public String newUser(Model model, @ModelAttribute("user") User user) {
        model.addAttribute("roles", roleService.getAll());
        return "admin/new";
    }
    
    @PostMapping
    public String create(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/admin/users";
    }
    
    @GetMapping("{id}/edit")
    public String edit(Model model,
                       @PathVariable("id") long id) {
        model.addAttribute("user", userService.getById(id));
        model.addAttribute("roles", roleService.getAll());
        return "admin/edit";
    }
    
    @PatchMapping("{id}")
    public String update(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/admin/users";
    }
    
    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") long id) {
        userService.deleteById(id);
        return "redirect:/admin/users";
    }
}
