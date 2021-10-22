package rtu.recruit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rtu.recruit.entities.ProductEntity;
import rtu.recruit.entities.UserEntity;
import rtu.recruit.exceptions.PurchaseDBException;
import rtu.recruit.exceptions.UserDBException;
import rtu.recruit.repos.ProductsRepo;
import rtu.recruit.repos.UserRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    ProductsRepo productsRepo;

    public ProductEntity addOrUpdate(ProductEntity product) {
        return productsRepo.save(product);
    }

    public List<ProductEntity> getAll() {
        return productsRepo.findAll();
    }


    public ProductEntity getById(long id) throws PurchaseDBException {
        if (!productsRepo.existsById(id)) throw new PurchaseDBException("Not found");
        return productsRepo.findById(id).get();
    }

    public long deleteById(long id) throws PurchaseDBException {
        if (!productsRepo.existsById(id)) throw new PurchaseDBException("Not found");
        productsRepo.deleteById(id);
        return id;
    }
}
