package kg.java.todolist.data;


import kg.java.todolist.core.models.entities.PriorityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PriorityRepository extends JpaRepository<PriorityEntity,Long> {
    Optional<PriorityEntity> findPriorityEntityByName(String name);
}
