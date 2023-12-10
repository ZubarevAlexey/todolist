package kg.java.todolist.core.mappers;


import kg.java.todolist.core.models.dtos.category.CategoryDto;
import kg.java.todolist.core.models.dtos.category.CreateCategoryDto;
import kg.java.todolist.core.models.dtos.category.UpdateCategoryDto;
import kg.java.todolist.core.models.dtos.user.UserDto;
import kg.java.todolist.core.models.entities.CategoryEntity;

public class CategoryMapper {
    public CategoryDto toDomain(CategoryEntity model) {
        var user = model.getUser();
        return CategoryDto.builder()
                .id(model.getId())
                .name(model.getName())
                .user(UserDto.builder()
                        .name(user.getName())
                        .email(user.getEmail())
                        .build())
                .build();
    }
    public CategoryEntity fromDomain(CreateCategoryDto model) {
        return CategoryEntity.builder()
                .name(model.getName())
                .build();
    }
    public CategoryEntity fromDomain(UpdateCategoryDto model) {
        return CategoryEntity.builder()
                .id(model.getId())
                .name(model.getName())
                .build();
    }

}
