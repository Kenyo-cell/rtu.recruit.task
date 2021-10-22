package rtu.recruit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rtu.recruit.entities.UserEntity;
import rtu.recruit.exceptions.UserDBException;
import rtu.recruit.repos.CheckRepo;
import rtu.recruit.repos.UserRepo;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    CheckRepo checkRepo;

    public UserEntity register(UserEntity entity) throws UserDBException {
        if (userRepo.findById(entity.getId()).isPresent()) {
            throw new UserDBException("User already exists");
        }
        return userRepo.save(entity);
    }

    public UserEntity update(long id, UserEntity entity) throws UserDBException {
        if (!userRepo.existsById(id)) throw new UserDBException("User not found");

        entity.setId(id);
        return userRepo.save(entity);
    }

    public long deleteById(long id) {
        userRepo.deleteById(id);
        return id;
    }

    public UserEntity getById(long id) throws UserDBException {
        if (!userRepo.existsById(id)) throw new UserDBException("User not found");
        return userRepo.getById(id);
    }
}
