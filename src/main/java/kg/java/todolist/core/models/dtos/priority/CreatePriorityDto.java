package kg.java.todolist.core.models.dtos.priority;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class CreatePriorityDto {
    private Long userId;
    private String name;
    private String color;
}
