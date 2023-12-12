package kg.java.todolist.core.models.dtos.user;

import kg.java.todolist.core.models.dtos.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class UpdateUserDto extends BaseDto {
    private String name;
    private String email;
    private String password;
}
