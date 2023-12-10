package kg.java.todolist.domain.facades;

import kg.java.todolist.core.exceptions.EntityNotFoundException;
import kg.java.todolist.core.contracts.facades.TaskFacade;
import kg.java.todolist.core.contracts.services.TaskService;
import kg.java.todolist.core.exceptions.EntityDuplicateException;
import kg.java.todolist.core.models.dtos.task.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class TaskFacadeImpl implements TaskFacade {
    private final TaskService taskService;

    public TaskFacadeImpl(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public TaskDto add(CreateTaskDto model) throws EntityDuplicateException, EntityNotFoundException {
        return taskService.add(model);
    }

    @Override
    public TaskDto update(UpdateTaskDto model) throws EntityNotFoundException {
        return taskService.update(model);
    }

    @Override
    public HttpStatus delete(DeleteTaskDto model) throws EntityNotFoundException {
        return taskService.delete(model);
    }

    @Override
    public TaskDto findById(FindByIdTaskDto model) throws EntityNotFoundException {
        return taskService.findById(model);
    }
}
