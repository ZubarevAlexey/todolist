package kg.java.todolist.core.mappers;


import kg.java.todolist.core.models.dtos.category.CategoryDto;
import kg.java.todolist.core.models.dtos.priority.PriorityDto;
import kg.java.todolist.core.models.dtos.task.CreateTaskDto;
import kg.java.todolist.core.models.dtos.task.TaskDto;
import kg.java.todolist.core.models.dtos.task.UpdateTaskDto;
import kg.java.todolist.core.models.dtos.user.UserDto;
import kg.java.todolist.core.models.entities.TaskEntity;

public class TaskMapper {
    public TaskDto toDomain(TaskEntity model){
        var user = model.getUser();
        var category = model.getCategory();
        var priority = model.getPriority();
        return TaskDto.builder()
                .id(model.getId())
                .taskDate(model.getTaskDate())
                .name(model.getName())
                .completed(model.getCompleted())
                .category(CategoryDto.builder()
                        .name(category.getName())
                        .build())
                .user(UserDto.builder()
                        .name(user.getName())
                        .email(user.getEmail())
                        .build())
                .priority(PriorityDto.builder()
                        .name(priority.getName())
                        .color(priority.getColor())
                        .build())
                .build();
    }
    public TaskEntity fromDomain(CreateTaskDto model) {
        return TaskEntity.builder()
                .taskDate(model.getTaskDate())
                .completed(model.getCompleted())
                .name(model.getName())
                .build();
    }
    public TaskEntity fromDomain(UpdateTaskDto model) {
        return TaskEntity.builder()
                .id(model.getId())
                .taskDate(model.getTaskDate())
                .completed(model.getCompleted())
                .name(model.getName())
                .build();
    }
}
