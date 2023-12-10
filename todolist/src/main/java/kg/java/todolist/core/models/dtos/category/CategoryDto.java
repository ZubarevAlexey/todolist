package kg.java.todolist.core.models.dtos.category;


import kg.java.todolist.core.models.dtos.user.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class CategoryDto {
    private Long id;
    private String name;
    private UserDto user;
}
