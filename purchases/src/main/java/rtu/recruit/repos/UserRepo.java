package rtu.recruit.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rtu.recruit.entities.UserEntity;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Long> {

}
