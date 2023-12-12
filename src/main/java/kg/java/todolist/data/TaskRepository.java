package kg.java.todolist.data;


import kg.java.todolist.core.models.dtos.task.TaskDto;
import kg.java.todolist.core.models.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity,Long> {
    Optional<TaskEntity> findTaskEntityByName(String name);

    @Query("select t from TaskEntity t " +
            "where t.user.name=:userName" +
            " and t.category.name=:categoryName " +
            "order by t.id asc ")
    List<TaskEntity> findByUserNameAndCategoryName(@Param("userName")String userName,
                                                @Param("categoryName")String categoryName);
}
