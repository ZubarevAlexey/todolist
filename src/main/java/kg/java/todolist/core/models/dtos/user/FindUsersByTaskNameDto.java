package kg.java.todolist.core.models.dtos.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindUsersByTaskNameDto {
    private String taskName;
}
