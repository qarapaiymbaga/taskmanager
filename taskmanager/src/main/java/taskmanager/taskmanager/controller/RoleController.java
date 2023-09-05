package taskmanager.taskmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import taskmanager.taskmanager.entity.Role;
import taskmanager.taskmanager.repository.RoleRepository;

@RestController
@RequestMapping("/roles")
public class RoleController {
    private RoleRepository roleRepository;

    @Autowired
    public RoleController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @PostMapping()
    public void createRole(@RequestParam String role) {;
        roleRepository.save(new Role(role));
    }
}
