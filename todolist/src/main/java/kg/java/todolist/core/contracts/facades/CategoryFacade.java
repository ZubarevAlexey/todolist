package kg.java.todolist.core.contracts.facades;

import kg.java.todolist.core.exceptions.EntityNotFoundException;
import kg.java.todolist.core.exceptions.EntityDuplicateException;
import kg.java.todolist.core.models.dtos.category.*;
import org.springframework.http.HttpStatus;

public interface CategoryFacade {
    CategoryDto add(CreateCategoryDto model) throws EntityDuplicateException, EntityNotFoundException;
    CategoryDto update(UpdateCategoryDto model) throws EntityNotFoundException;
    HttpStatus delete(DeleteCategoryDto model) throws EntityNotFoundException;
    CategoryDto findById(FindByIdCategoryDto model) throws EntityNotFoundException;
}
