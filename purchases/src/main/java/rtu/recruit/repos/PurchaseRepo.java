package rtu.recruit.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import rtu.recruit.entities.ProductEntity;

import java.util.List;


public interface PurchaseRepo extends JpaRepository<ProductEntity, Long> {
    public List<ProductEntity> findAllByUserId(long id);
}
