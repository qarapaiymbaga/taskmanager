package taskmanager.taskmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import taskmanager.taskmanager.dto.TaskDto;
import taskmanager.taskmanager.entity.Task;
import taskmanager.taskmanager.service.TaskService;

import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/create")
    public String createTaskForm() {
        return "create-task";
    }

    @PostMapping("/create")
    public String createTask(@ModelAttribute TaskDto taskDto) {
        Task task = taskService.createTask(taskDto.getName(), taskDto.isCompleted(), taskDto.getDescription());
        return "redirect:/tasks/" + task.getId();
    }

    @GetMapping("/{id}")
    public String getTaskById(@PathVariable("id") Long id, Model model) {
        Task task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        return "task-details";
    }

    @GetMapping("/update/{id}")
    public String updateTaskForm(@PathVariable("id") Long id, Model model) {
        Task task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        return "update-task";
    }

    @PostMapping("/update")
    public String updateTask(@ModelAttribute Task taskDto) {
        Task task = taskService.updateTask(taskDto.getId(), taskDto.getName(), taskDto.isCompleted(), taskDto.getDescription());
        return "redirect:/tasks/" + task.getId();
    }

    @GetMapping("/delete/{id}")
    public String deleteTaskForm(@PathVariable("id") Long id, Model model) {
        Task task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        return "delete-task";
    }

    @PostMapping("/delete")
    public String deleteTask(@ModelAttribute Task taskDto) {
        taskService.deleteTaskById(taskDto.getId());
        return "redirect:/task-list";
    }

    @GetMapping("/list")
    public String taskList(Model model) {
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "task-list";
    }
}
