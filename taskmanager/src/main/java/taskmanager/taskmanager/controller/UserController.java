package taskmanager.taskmanager.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import taskmanager.taskmanager.entity.Role;
import taskmanager.taskmanager.entity.User;
import taskmanager.taskmanager.repository.RoleRepository;
import taskmanager.taskmanager.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final RoleRepository roleRepository;

    @Autowired
    public UserController(UserService userService, RoleRepository roleRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
    }

    @GetMapping("/register")
    public String registrationForm(Model model) {
        List<Role> roles = roleRepository.findAll();
        model.addAttribute("roles", roles);
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/register")
    public String registrationSubmit(User user) {
        userService.createUser(user.getUsername(), user.getPassword(), user.getRole());
        return "redirect:/users/login";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login() {
        return "task-list";
    }
}

