package rtu.recruit.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import rtu.recruit.entities.CheckItemEntity;
import rtu.recruit.entities.keys.CheckItemId;

import java.util.List;

public interface CheckItemRepo extends JpaRepository<CheckItemEntity, CheckItemId> {
    @Query(value = "INSERT INTO check_items VALUES(:check_id, :product_id, :count)",
            nativeQuery = true)
    CheckItemEntity insert(@Param("check_id") long check_id,
                           @Param("product_id") long product_id,
                           @Param("count") double count);

    @Query(value = "SELECT c FROM CheckItemEntity c WHERE c.check.id = :id")
    List<CheckItemEntity> getAllByCheckId(@Param("id") long checkId);
}
