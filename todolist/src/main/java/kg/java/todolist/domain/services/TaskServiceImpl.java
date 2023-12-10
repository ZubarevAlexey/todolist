package kg.java.todolist.domain.services;

import kg.java.todolist.core.exceptions.EntityNotFoundException;
import kg.java.todolist.core.contracts.services.TaskService;
import kg.java.todolist.core.exceptions.EntityDuplicateException;
import kg.java.todolist.core.mappers.TaskMapper;
import kg.java.todolist.core.models.dtos.task.*;
import kg.java.todolist.data.CategoryRepository;
import kg.java.todolist.data.PriorityRepository;
import kg.java.todolist.data.TaskRepository;
import kg.java.todolist.data.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final PriorityRepository priorityRepository;

    public TaskServiceImpl(TaskRepository taskRepository, TaskMapper taskMapper, UserRepository userRepository,
                           CategoryRepository categoryRepository, PriorityRepository priorityRepository) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.priorityRepository = priorityRepository;
    }

    @Override
    public TaskDto add(CreateTaskDto model) throws EntityDuplicateException, EntityNotFoundException {
        var user = userRepository.findById(model.getUserId()).orElseThrow(EntityNotFoundException::new);
        var category = categoryRepository.findById(model.getCategoryId()).orElseThrow(EntityNotFoundException::new);
        var priority = priorityRepository.findById(model.getPriorityId()).orElseThrow(EntityNotFoundException::new);
        var task = taskRepository.findTaskEntityByName(model.getName());
        if (task.isPresent()) throw new EntityDuplicateException();
        var entity = taskMapper.fromDomain(model);
        entity.setUser(user);
        entity.setCategory(category);
        entity.setPriority(priority);
        taskRepository.save(entity);
        return taskMapper.toDomain(entity);
    }

    @Override
    public TaskDto update(UpdateTaskDto model) throws EntityNotFoundException {
        var user = userRepository.findById(model.getUserId()).orElseThrow(EntityNotFoundException::new);
        var category = categoryRepository.findById(model.getCategoryId()).orElseThrow(EntityNotFoundException::new);
        var priority = priorityRepository.findById(model.getPriorityId()).orElseThrow(EntityNotFoundException::new);
        var task = taskRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        var entity = task.toBuilder()
                .id(model.getId())
                .taskDate(model.getTaskDate())
                .completed(model.getCompleted())
                .user(user)
                .category(category)
                .priority(priority)
                .name(model.getName())
                .build();
        taskRepository.save(entity);
        return taskMapper.toDomain(entity);
    }

    @Override
    public HttpStatus delete(DeleteTaskDto model) throws EntityNotFoundException {
        var task = taskRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        taskRepository.delete(task);
        return HttpStatus.OK;
    }

    @Override
    public TaskDto findById(FindByIdTaskDto model) throws EntityNotFoundException {
        var task = taskRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        return taskMapper.toDomain(task);
    }
}
