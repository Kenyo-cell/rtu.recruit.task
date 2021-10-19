package rtu.recruit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rtu.recruit.entities.PurchaseEntity;
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

    public PurchaseEntity addOrUpdate(long userId, PurchaseEntity purchase) throws UserDBException {
        Optional<UserEntity> user = userRepo.findById(userId);
        if (!user.isPresent()) throw new UserDBException("User not found");
        purchase.setUser(user.get());
        return purchaseRepo.save(purchase);
    }

    public List<PurchaseEntity> getAllByUserId(long userId) {
        List<PurchaseEntity> entities = purchaseRepo.findAllByUserId(userId);
        return entities;
    }

    public PurchaseEntity getById(long id) throws PurchaseDBException {
        if (!purchaseRepo.existsById(id)) throw new PurchaseDBException("Not found");
        return purchaseRepo.findById(id).get();
    }

    public long deleteById(long id) throws PurchaseDBException {
        if (!purchaseRepo.existsById(id)) throw new PurchaseDBException("Not found");
        purchaseRepo.deleteById(id);
        return id;
    }
}
