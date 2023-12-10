package kg.java.todolist.core.contracts.facades;

import kg.java.todolist.core.exceptions.EntityNotFoundException;
import kg.java.todolist.core.exceptions.EntityDuplicateException;
import kg.java.todolist.core.models.dtos.user.*;
import org.springframework.http.HttpStatus;

public interface UserFacade {
    UserDto add(CreateUserDto model)throws EntityDuplicateException;
    UserDto update(UpdateUserDto model) throws EntityNotFoundException;
    HttpStatus delete(DeleteUserDto model) throws EntityNotFoundException;
    UserDto findById(FindByIdUserDto model) throws EntityNotFoundException;
}
