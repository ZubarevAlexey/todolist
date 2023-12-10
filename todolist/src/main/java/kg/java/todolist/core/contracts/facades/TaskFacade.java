package kg.java.todolist.core.contracts.facades;

import kg.java.todolist.core.exceptions.EntityNotFoundException;
import kg.java.todolist.core.exceptions.EntityDuplicateException;
import kg.java.todolist.core.models.dtos.task.*;
import org.springframework.http.HttpStatus;

public interface TaskFacade {
    TaskDto add(CreateTaskDto model) throws EntityDuplicateException, EntityNotFoundException;
    TaskDto update(UpdateTaskDto model) throws EntityNotFoundException;
    HttpStatus delete(DeleteTaskDto model) throws EntityNotFoundException;
    TaskDto findById(FindByIdTaskDto model) throws EntityNotFoundException;
}
