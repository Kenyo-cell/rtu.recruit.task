package rtu.recruit.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import rtu.recruit.entities.CheckEntity;

public interface CheckRepo extends JpaRepository<CheckEntity, Long> {

}
