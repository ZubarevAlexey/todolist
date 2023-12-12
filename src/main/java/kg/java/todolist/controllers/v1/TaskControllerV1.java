package kg.java.todolist.controllers.v1;

import kg.java.todolist.core.exceptions.EntityNotFoundException;
import kg.java.todolist.core.contracts.facades.TaskFacade;
import kg.java.todolist.core.exceptions.EntityDuplicateException;
import kg.java.todolist.core.models.dtos.task.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/task")
public class TaskControllerV1 {
private final TaskFacade taskFacade;

    public TaskControllerV1(TaskFacade taskFacade) {
        this.taskFacade = taskFacade;
    }

    @PostMapping("/add")
    public ResponseEntity<TaskDto> add (@RequestBody CreateTaskDto model) {
        try {
            return ResponseEntity.ok(taskFacade.add(model));
        }
        catch (EntityDuplicateException e){
            return ResponseEntity.badRequest().build();
        }
        catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/update")
    public ResponseEntity<TaskDto> update (@RequestBody UpdateTaskDto model) {
        try {
            return ResponseEntity.ok(taskFacade.update(model));
        }
        catch (EntityNotFoundException e){
            return ResponseEntity.badRequest().build();
        }
        catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/delete")
    public ResponseEntity<HttpStatus> delete (@RequestBody DeleteTaskDto model) {
        try {
            return ResponseEntity.ok(taskFacade.delete(model));
        }
        catch (EntityNotFoundException e){
            return ResponseEntity.badRequest().build();
        }
        catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/id")
    public ResponseEntity<TaskDto> findById (@RequestBody FindByIdTaskDto model) {
        try {
            return ResponseEntity.ok(taskFacade.findById(model));
        }
        catch (EntityNotFoundException e){
            return ResponseEntity.badRequest().build();
        }
        catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("names")
    public ResponseEntity<List<TaskDto>> findByUserNameAndCategoryName(
            @RequestBody  FindTaskByUserNameAndCategoryNameDto  model){
        try {
            return ResponseEntity.ok(taskFacade.findByUserNameAndCategoryName(model));
        }
        catch (Exception e){
            return ResponseEntity.notFound().build();
        }



    }
}
