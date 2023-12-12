package kg.java.todolist.core.mappers;


import kg.java.todolist.core.models.dtos.priority.CreatePriorityDto;
import kg.java.todolist.core.models.dtos.priority.PriorityDto;
import kg.java.todolist.core.models.dtos.priority.UpdatePriorityDto;
import kg.java.todolist.core.models.dtos.user.UserDto;
import kg.java.todolist.core.models.entities.PriorityEntity;

public class PriorityMapper {
    public PriorityDto toDomain(PriorityEntity model){
        var user = model.getUser();
        return PriorityDto.builder()
                .id(model.getId())
                .name(model.getName())
                .color(model.getColor())
                .user(UserDto.builder()
                        .name(user.getName())
                        .email(user.getEmail())
                        .password(user.getPassword())
                        .build()).build();
    }
    public PriorityEntity fromDomain(CreatePriorityDto model){
        return PriorityEntity.builder()
                .name(model.getName())
                .color(model.getColor())
                .build();
    }
    public PriorityEntity fromDomain(UpdatePriorityDto model){
        return PriorityEntity.builder()
                .id(model.getId())
                .name(model.getName())
                .color(model.getColor())
                .build();
    }

}
