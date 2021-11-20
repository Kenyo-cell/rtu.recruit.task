package rtu.recruit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rtu.recruit.entities.CheckEntity;
import rtu.recruit.entities.CheckItemEntity;
import rtu.recruit.entities.ProductEntity;
import rtu.recruit.entities.UserEntity;
import rtu.recruit.entities.keys.CheckItemId;
import rtu.recruit.exceptions.UserDBException;
import rtu.recruit.repos.CheckRepo;
import rtu.recruit.repos.ProductsRepo;
import rtu.recruit.repos.UserRepo;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CheckRepo checkRepo;

    @Autowired
    private ProductsRepo productsRepo;

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

    public boolean addProductItem(long user_id, long item_id, double count) throws UserDBException {
        if (!userRepo.existsById(user_id)) throw new UserDBException("User not found");
        CheckEntity check = checkRepo.findFirstByUserIdAndNotClosed(user_id);
//        check.getItems().add(new CheckItemEntity(check.getId(), item_id, count));
        check.getItems().add(new CheckItemEntity(new CheckItemId(check.getId(), item_id), count));
        return true;
    }
}
