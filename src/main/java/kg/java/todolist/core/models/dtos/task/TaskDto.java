package kg.java.todolist.core.models.dtos.task;

import kg.java.todolist.core.models.dtos.category.CategoryDto;
import kg.java.todolist.core.models.dtos.priority.PriorityDto;
import kg.java.todolist.core.models.dtos.user.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class TaskDto {
    private Long id;
    private String name;
    private int completed;
    private Date taskDate;
    private UserDto user;
    private PriorityDto priority;
    private CategoryDto category;

}
