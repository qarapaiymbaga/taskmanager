package taskmanager.taskmanager.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import taskmanager.taskmanager.entity.User;
import taskmanager.taskmanager.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    @Getter
    private User user;

    @Autowired
    public CustomUserDetailsService(UserRepository accountRepository) {
        this.userRepository = accountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User account = userRepository.findUserByUsername(s);
        this.user = account;
        if (account == null) {
            throw new UsernameNotFoundException("User with such username doesn't exist");
        }
        return account;
    }
}

