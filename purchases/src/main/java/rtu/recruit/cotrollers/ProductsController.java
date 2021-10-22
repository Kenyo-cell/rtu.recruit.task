package rtu.recruit.cotrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rtu.recruit.entities.ProductEntity;
import rtu.recruit.services.ProductsService;

@RestController
public class ProductsController {

    @Autowired
    ProductsService productsService;

    @PostMapping(value = "/products/add")
    public ResponseEntity add(@RequestBody ProductEntity product) {
        try {
            return ResponseEntity.ok(productsService.addOrUpdate(product));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(value = "/products")
    public ResponseEntity getAll() {
        try {
            return ResponseEntity.ok(productsService.getAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(value = "/products/{id}")
    public ResponseEntity getProductById(@PathVariable long id) {
        try {
            return ResponseEntity.ok(productsService.getById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/products/{id}")
    public ResponseEntity deleteProductById(@PathVariable long id) {
        try {
            return ResponseEntity.ok(productsService.deleteById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
