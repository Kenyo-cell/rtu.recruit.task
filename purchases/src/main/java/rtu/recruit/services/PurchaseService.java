package rtu.recruit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rtu.recruit.entities.ProductEntity;
import rtu.recruit.entities.UserEntity;
import rtu.recruit.exceptions.PurchaseDBException;
import rtu.recruit.exceptions.UserDBException;
import rtu.recruit.repos.PurchaseRepo;
import rtu.recruit.repos.UserRepo;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    PurchaseRepo purchaseRepo;

    public ProductEntity addOrUpdate(long userId, ProductEntity product) throws UserDBException {
        Optional<UserEntity> user = userRepo.findById(userId);
        if (!user.isPresent()) throw new UserDBException("User not found");

        return purchaseRepo.save(product);
    }

    public List<ProductEntity> getAllByUserId(long userId) {
        List<ProductEntity> entities = purchaseRepo.findAll();
        return entities;
    }

    public ProductEntity getById(long id) throws PurchaseDBException {
        if (!purchaseRepo.existsById(id)) throw new PurchaseDBException("Not found");
        return purchaseRepo.findById(id).get();
    }

    public long deleteById(long id) throws PurchaseDBException {
        if (!purchaseRepo.existsById(id)) throw new PurchaseDBException("Not found");
        purchaseRepo.deleteById(id);
        return id;
    }
}
