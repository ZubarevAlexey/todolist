package kg.java.todolist.data;


import kg.java.todolist.core.models.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity,Long> {
    Optional<TaskEntity> findTaskEntityByName(String name);
}
