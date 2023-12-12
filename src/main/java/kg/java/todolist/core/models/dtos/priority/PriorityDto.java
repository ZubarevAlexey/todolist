package kg.java.todolist.core.models.dtos.priority;

import kg.java.todolist.core.models.dtos.user.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class PriorityDto {
    private Long id;
    private String name;
    private String color;
    private UserDto user;
}
