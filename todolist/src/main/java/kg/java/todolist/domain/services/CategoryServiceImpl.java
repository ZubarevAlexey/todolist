package kg.java.todolist.domain.services;

import kg.java.todolist.core.exceptions.EntityNotFoundException;
import kg.java.todolist.core.contracts.services.CategoryService;
import kg.java.todolist.core.exceptions.EntityDuplicateException;
import kg.java.todolist.core.mappers.CategoryMapper;
import kg.java.todolist.core.models.dtos.category.*;
import kg.java.todolist.data.CategoryRepository;
import kg.java.todolist.data.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    private final UserRepository userRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper,
                               UserRepository userRepository) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
        this.userRepository = userRepository;
    }

    @Override
    public CategoryDto add(CreateCategoryDto model) throws EntityDuplicateException, EntityNotFoundException {
        var user = userRepository.findById(model.getUserId()).orElseThrow(EntityNotFoundException::new);
        var category = categoryRepository.findCategoryEntityByName(model.getName());
        if (category.isPresent()) throw new EntityDuplicateException();
        var entity = categoryMapper.fromDomain(model);
        entity.setUser(user);
        categoryRepository.save(entity);
        return categoryMapper.toDomain(entity);
    }

    @Override
    public CategoryDto update(UpdateCategoryDto model) throws EntityNotFoundException {
        var user = userRepository.findById(model.getUserId()).orElseThrow(EntityNotFoundException::new);
        var category = categoryRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        var entity = category.toBuilder()
                .id(model.getId())
                .name(model.getName())
                .user(user)
                .build();
        categoryRepository.save(entity);
        return categoryMapper.toDomain(entity);
    }

    @Override
    public HttpStatus delete(DeleteCategoryDto model) throws EntityNotFoundException {
        var category = categoryRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        categoryRepository.delete(category);
        return HttpStatus.OK;
    }

    @Override
    public CategoryDto findById(FindByIdCategoryDto model) throws EntityNotFoundException {
        var category = categoryRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        return categoryMapper.toDomain(category);
    }
}
