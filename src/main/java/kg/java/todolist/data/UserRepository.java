package kg.java.todolist.data;


import kg.java.todolist.core.models.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findUserEntityByName(String name);
    @Query("select u from UserEntity u " +
            "inner join TaskEntity t on u.id = t.user.id" +
            " where t.name=:taskName" +
            " group by u order by u.name asc ")
    List<UserEntity> findByTaskName(@Param("taskName")String taskName);
}
