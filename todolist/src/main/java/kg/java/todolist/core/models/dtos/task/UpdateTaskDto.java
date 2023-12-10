package kg.java.todolist.core.models.dtos.task;

import kg.java.todolist.core.models.dtos.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class UpdateTaskDto extends BaseDto {
    private String name;
    private int completed;
    private Date taskDate;
    private Long userId;
    private Long priorityId;
    private Long categoryId;

}
