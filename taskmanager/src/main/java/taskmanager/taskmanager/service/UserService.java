package taskmanager.taskmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import taskmanager.taskmanager.entity.Role;
import taskmanager.taskmanager.entity.Task;
import taskmanager.taskmanager.entity.User;
import taskmanager.taskmanager.repository.TaskRepository;
import taskmanager.taskmanager.repository.UserRepository;

import java.time.LocalDate;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String name, String password, Role role) {
        User user = mapUser(name, password, role);
        return userRepository.save(user);
    }

    private User mapUser(String name, String password, Role role){
        User user = new User();
        user.setUsername(name);
        user.setPassword(password);
        user.setRole(role);
        return user;
    }
}
