package kg.java.todolist.domain.facades;
import kg.java.todolist.core.exceptions.EntityNotFoundException;
import kg.java.todolist.core.contracts.facades.UserFacade;
import kg.java.todolist.core.contracts.services.UserService;
import kg.java.todolist.core.exceptions.EntityDuplicateException;
import kg.java.todolist.core.models.dtos.user.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserFacadeImpl implements UserFacade {
    private final UserService userService;

    public UserFacadeImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDto add(CreateUserDto model) throws EntityDuplicateException {
        return userService.add(model);
    }

    @Override
    public UserDto update(UpdateUserDto model) throws EntityNotFoundException {
        return userService.update(model);
    }

    @Override
    public HttpStatus delete(DeleteUserDto model) throws EntityNotFoundException {
        return userService.delete(model);
    }

    @Override
    public UserDto findById(FindByIdUserDto model) throws EntityNotFoundException {
        return userService.findById(model);
    }
}
