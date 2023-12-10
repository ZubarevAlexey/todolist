package kg.java.todolist.domain.facades;

import kg.java.todolist.core.exceptions.EntityNotFoundException;
import kg.java.todolist.core.contracts.facades.PriorityFacade;
import kg.java.todolist.core.contracts.services.PriorityService;
import kg.java.todolist.core.exceptions.EntityDuplicateException;
import kg.java.todolist.core.models.dtos.priority.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PriorityFacadeImpl implements PriorityFacade {
    private final PriorityService priorityService;

    public PriorityFacadeImpl(PriorityService priorityService) {
        this.priorityService = priorityService;

    }

    @Override
    public PriorityDto add(CreatePriorityDto model) throws EntityDuplicateException, EntityNotFoundException {
        return priorityService.add(model);
    }

    @Override
    public PriorityDto update(UpdatePriorityDto model) throws EntityNotFoundException {
        return priorityService.update(model);
    }

    @Override
    public HttpStatus delete(DeletePriorityDto model) throws EntityNotFoundException {
        return priorityService.delete(model);
    }

    @Override
    public PriorityDto findById(FindByIdPriorityDto model) throws EntityNotFoundException {
        return priorityService.findById(model);
    }
}
