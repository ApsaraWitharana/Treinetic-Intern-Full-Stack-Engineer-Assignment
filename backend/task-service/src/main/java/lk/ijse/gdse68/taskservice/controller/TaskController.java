package lk.ijse.gdse68.taskservice.controller;

import lk.ijse.gdse68.taskservice.dto.TaskDTO;
import lk.ijse.gdse68.taskservice.exception.DataPersistFailedException;
import lk.ijse.gdse68.taskservice.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tasks")

public class TaskController {

    private final TaskService taskService;


    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    //TODO: getAll Task
    @GetMapping
    public ResponseEntity<List<TaskDTO>> getAllTask(){
        List<TaskDTO> tasks = taskService.getAll();
        return ResponseEntity.ok(tasks);
    }

    //TODO: save Task
    @PostMapping
    public ResponseEntity<String> saveTask(@RequestBody TaskDTO taskDTO){
        try {
            taskService.save(taskDTO);
            return ResponseEntity.status(201).body("Task saved successfully!!");
        } catch (DataPersistFailedException ex) {
            return ResponseEntity.status(500).body(ex.getMessage()); // Internal Server Error
        }
    }


    //TODO: delete Task
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id){
        taskService.delete(id);
        return ResponseEntity.ok("Task delete successfully!!");
    }

    //TODO: update Task
    @PatchMapping( "/{id}")
    public ResponseEntity<String> updateTask(@PathVariable Long id, @RequestBody TaskDTO taskDTO ) throws ClassNotFoundException {
        taskService.update(id,taskDTO);
        return ResponseEntity.ok("Task update successfully!!");
    }

    //TODO: get select task
    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> getSelectTask(@PathVariable Long id){
        TaskDTO taskDTO = taskService.get(id);
        return ResponseEntity.ok(taskDTO);
    }
}
