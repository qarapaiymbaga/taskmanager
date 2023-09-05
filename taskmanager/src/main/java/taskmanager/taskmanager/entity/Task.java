package taskmanager.taskmanager.entity;

import lombok.Data;
import java.time.LocalDate;
import javax.persistence.*;

@Data
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private LocalDate creationDate;
    private boolean isCompleted;
}
