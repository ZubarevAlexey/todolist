package kg.java.todolist.domain.services;

import kg.java.todolist.core.exceptions.EntityNotFoundException;
import kg.java.todolist.core.contracts.services.PriorityService;
import kg.java.todolist.core.exceptions.EntityDuplicateException;
import kg.java.todolist.core.mappers.PriorityMapper;
import kg.java.todolist.core.models.dtos.priority.*;
import kg.java.todolist.data.PriorityRepository;
import kg.java.todolist.data.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PriorityServiceImpl implements PriorityService {
    private final PriorityRepository priorityRepository;
    private final PriorityMapper priorityMapper;
    private final UserRepository userRepository;

    public PriorityServiceImpl(PriorityRepository priorityRepository, PriorityMapper priorityMapper,
                               UserRepository userRepository) {
        this.priorityRepository = priorityRepository;
        this.priorityMapper = priorityMapper;
        this.userRepository = userRepository;
    }


    @Override
    public PriorityDto add(CreatePriorityDto model) throws EntityDuplicateException, EntityNotFoundException {
        var priority = priorityRepository.findPriorityEntityByName(model.getName());
        if (priority.isPresent()) throw new EntityDuplicateException();
        var user = userRepository.findById(model.getUserId()).orElseThrow(EntityNotFoundException::new);
        var entity = priorityMapper.fromDomain(model);
        entity.setUser(user);
        priorityRepository.save(entity);
        return priorityMapper.toDomain(entity);
    }

    @Override
    public PriorityDto update(UpdatePriorityDto model) throws EntityNotFoundException {
        var user = userRepository.findById(model.getUserId()).orElseThrow(EntityNotFoundException::new);
        var priority = priorityRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        var entity = priority.toBuilder()
                .id(model.getId())
                .name(model.getName())
                .color(model.getColor())
                .user(user)
                .build();
        priorityRepository.save(entity);
        return priorityMapper.toDomain(entity);
    }

    @Override
    public HttpStatus delete(DeletePriorityDto model) throws EntityNotFoundException {
        var priority = priorityRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        priorityRepository.delete(priority);
        return HttpStatus.OK;
    }

    @Override
    public PriorityDto findById(FindByIdPriorityDto model) throws EntityNotFoundException {
        var priority = priorityRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        return priorityMapper.toDomain(priority);
    }
}
