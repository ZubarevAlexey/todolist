package kg.java.todolist.core.contracts.services;

import kg.java.todolist.core.exceptions.EntityNotFoundException;
import kg.java.todolist.core.exceptions.EntityDuplicateException;
import kg.java.todolist.core.models.dtos.priority.*;
import org.springframework.http.HttpStatus;

public interface PriorityService {
    PriorityDto add(CreatePriorityDto model) throws EntityDuplicateException, EntityNotFoundException;
    PriorityDto update(UpdatePriorityDto model) throws EntityNotFoundException;
    HttpStatus delete(DeletePriorityDto model) throws EntityNotFoundException;
    PriorityDto findById(FindByIdPriorityDto model) throws EntityNotFoundException;
}
