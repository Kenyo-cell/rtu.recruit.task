package rtu.recruit.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import rtu.recruit.entities.PurchaseEntity;
import rtu.recruit.entities.UserEntity;

import java.util.List;
import java.util.Optional;


public interface PurchaseRepo extends JpaRepository<PurchaseEntity, Long> {
    public List<PurchaseEntity> findAllByUserId(long id);
}
