package kg.java.todolist.domain.facades;

import kg.java.todolist.core.exceptions.EntityNotFoundException;
import kg.java.todolist.core.contracts.facades.CategoryFacade;
import kg.java.todolist.core.contracts.services.CategoryService;
import kg.java.todolist.core.exceptions.EntityDuplicateException;
import kg.java.todolist.core.models.dtos.category.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CategoryFacadeImpl implements CategoryFacade {
    private final CategoryService categoryService;

    public CategoryFacadeImpl(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public CategoryDto add(CreateCategoryDto model) throws EntityDuplicateException, EntityNotFoundException {
        return categoryService.add(model);
    }

    @Override
    public CategoryDto update(UpdateCategoryDto model) throws EntityNotFoundException {
        return categoryService.update(model);
    }

    @Override
    public HttpStatus delete(DeleteCategoryDto model) throws EntityNotFoundException {
        return categoryService.delete(model);
    }

    @Override
    public CategoryDto findById(FindByIdCategoryDto model) throws EntityNotFoundException {
        return categoryService.findById(model);
    }
}
