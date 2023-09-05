package taskmanager.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import taskmanager.taskmanager.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findUserByUsername(String name);
}
