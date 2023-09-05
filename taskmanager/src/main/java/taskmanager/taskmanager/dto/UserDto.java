package taskmanager.taskmanager.dto;

import lombok.Data;
import taskmanager.taskmanager.entity.Role;

@Data
public class UserDto {
        private Long id;
        private String name;
        private Role role;
}
