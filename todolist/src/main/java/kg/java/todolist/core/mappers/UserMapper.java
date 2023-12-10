package kg.java.todolist.core.mappers;

import kg.java.todolist.core.models.dtos.user.CreateUserDto;
import kg.java.todolist.core.models.dtos.user.UpdateUserDto;
import kg.java.todolist.core.models.dtos.user.UserDto;
import kg.java.todolist.core.models.entities.UserEntity;

public class UserMapper {
    public UserDto toDomain(UserEntity model) {
        return UserDto.builder()
                .id(model.getId())
                .name(model.getName())
                .email(model.getEmail())
                .password(model.getPassword())
                .build();
    }
    public UserEntity fromDomain(CreateUserDto model) {
        return UserEntity.builder()
                .name(model.getName())
                .email(model.getEmail())
                .password(model.getPassword())
                .build();
    }
    public UserEntity fromDomain(UpdateUserDto model) {
        return UserEntity.builder()
                .id(model.getId())
                .name(model.getName())
                .email(model.getEmail())
                .password(model.getPassword())
                .build();
    }
}
