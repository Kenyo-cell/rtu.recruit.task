package rtu.recruit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rtu.recruit.entities.UserEntity;
import rtu.recruit.exceptions.UserDBException;
import rtu.recruit.repos.UserRepo;

@Service
public class UserService {
    @Autowired
    UserRepo repo;

    public UserEntity register(UserEntity entity) throws UserDBException {
        if (repo.findById(entity.getId()).isPresent()) {
            throw new UserDBException("User already exists");
        }
        return repo.save(entity);
    }

    public UserEntity update(long id, UserEntity entity) throws UserDBException {
        if (!repo.existsById(id)) throw new UserDBException("User not found");

        entity.setId(id);
        return repo.save(entity);
    }

    public long deleteById(long id) {
        repo.deleteById(id);
        return id;
    }

    public UserEntity getById(long id) throws UserDBException {
        if (!repo.existsById(id)) throw new UserDBException("User not found");
        return repo.getById(id);
    }
}
