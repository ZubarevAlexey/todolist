package kg.java.todolist.domain.services;

import kg.java.todolist.core.exceptions.EntityNotFoundException;
import kg.java.todolist.core.contracts.services.UserService;
import kg.java.todolist.core.exceptions.EntityDuplicateException;
import kg.java.todolist.core.mappers.UserMapper;
import kg.java.todolist.core.models.dtos.user.*;
import kg.java.todolist.data.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto add(CreateUserDto model) throws EntityDuplicateException {
        var user = userRepository.findUserEntityByName(model.getName());
        if (user.isPresent()) throw new EntityDuplicateException();
        var entity = userMapper.fromDomain(model);
        userRepository.save(entity);
        return userMapper.toDomain(entity);
    }

    @Override
    public UserDto update(UpdateUserDto model) throws EntityNotFoundException {
        var user = userRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        var entity = user.toBuilder()
                .id(model.getId())
                .email(model.getEmail())
                .name(model.getName())
                .password(model.getPassword())
                .build();
        userRepository.save(entity);
        return userMapper.toDomain(entity);
    }

    @Override
    public HttpStatus delete(DeleteUserDto model) throws EntityNotFoundException {
        var user = userRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        userRepository.delete(user);
        return HttpStatus.OK;
    }

    @Override
    public UserDto findById(FindByIdUserDto model) throws EntityNotFoundException {
        var user = userRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        return userMapper.toDomain(user);
    }

    @Override
    public List<UserDto> findByTaskName(FindUsersByTaskNameDto model) {
        var users = userRepository.findByTaskName(model.getTaskName());
        return users.stream().map(userMapper::toDomain).collect(Collectors.toList());
    }
}
