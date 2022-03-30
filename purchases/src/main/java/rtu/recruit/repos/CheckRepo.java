package rtu.recruit.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import rtu.recruit.entities.CheckEntity;

import java.util.List;

public interface CheckRepo extends JpaRepository<CheckEntity, Long> {
    @Query(value = "SELECT c FROM CheckEntity c WHERE c.user.id = :id and c.closed = FALSE")
    CheckEntity findFirstByUserIdAndNotClosed(@Param("id") long userId);

    List<CheckEntity> findAllByUserId(long userId);
}
