package taskmanager.taskmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import taskmanager.taskmanager.entity.Task;
import taskmanager.taskmanager.repository.TaskRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class TaskService {
    private TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(String name, boolean isCompleted, String description) {
        Task task = mapTask(name,description, isCompleted);
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, String name, boolean completed, String description) {
        Task task = mapTask(name, description, completed);
        task.setId(id);
        return taskRepository.save(task);
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).get();
    }

    public void deleteTaskById(Long id) {
        taskRepository.deleteById(id);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    private Task mapTask(String name, String description, boolean isCompleted){
        Task task = new Task();
        task.setCompleted(isCompleted);
        task.setName(name);
        task.setDescription(description);
        task.setCreationDate(LocalDate.now());
        return task;
    }

}