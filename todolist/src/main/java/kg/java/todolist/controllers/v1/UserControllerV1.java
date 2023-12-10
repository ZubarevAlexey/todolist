package kg.java.todolist.controllers.v1;

import kg.java.todolist.core.exceptions.EntityNotFoundException;
import kg.java.todolist.core.contracts.facades.UserFacade;
import kg.java.todolist.core.exceptions.EntityDuplicateException;
import kg.java.todolist.core.models.dtos.user.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserControllerV1 {
    private final UserFacade userFacade;

    public UserControllerV1(UserFacade userFacade) {
        this.userFacade = userFacade;
    }
    @PostMapping("/add")
    public ResponseEntity<UserDto> add (@RequestBody CreateUserDto model) {
        try {
            return ResponseEntity.ok(userFacade.add(model));
        }
        catch (EntityDuplicateException e){
            return ResponseEntity.badRequest().build();
        }
        catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/update")
    public ResponseEntity<UserDto> update (@RequestBody UpdateUserDto model) {
        try {
            return ResponseEntity.ok(userFacade.update(model));
        }
        catch (EntityNotFoundException e){
            return ResponseEntity.badRequest().build();
        }
        catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/delete")
    public ResponseEntity<HttpStatus> delete (@RequestBody DeleteUserDto model) {
        try {
            return ResponseEntity.ok(userFacade.delete(model));
        }
        catch (EntityNotFoundException e){
            return ResponseEntity.badRequest().build();
        }
        catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/id")
    public ResponseEntity<UserDto> findById (@RequestBody FindByIdUserDto model) {
        try {
            return ResponseEntity.ok(userFacade.findById(model));
        }
        catch (EntityNotFoundException e){
            return ResponseEntity.badRequest().build();
        }
        catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
