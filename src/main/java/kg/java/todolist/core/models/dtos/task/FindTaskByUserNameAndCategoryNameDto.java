package kg.java.todolist.core.models.dtos.task;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindTaskByUserNameAndCategoryNameDto {
    private String userName;
    private String categoryName;
}
