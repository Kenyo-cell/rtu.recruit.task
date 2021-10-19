package rtu.recruit.cotrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rtu.recruit.entities.PurchaseEntity;
import rtu.recruit.services.PurchaseService;

@RestController
public class PurchaseController {

    @Autowired
    PurchaseService purchaseService;

    @PostMapping(value = "/{userId}")
    public ResponseEntity add(@PathVariable Long userId, @RequestBody PurchaseEntity purchase) {
        try {
            return ResponseEntity.ok(purchaseService.addOrUpdate(userId, purchase));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(value = "/purchases")
    public ResponseEntity getAllByUserId(@RequestParam(name = "userId") Long userId) {
        try {
            return ResponseEntity.ok(purchaseService.getAllByUserId(userId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(value = "/purchases/{id}")
    public ResponseEntity getPurchaseById(@PathVariable long id) {
        try {
            return ResponseEntity.ok(purchaseService.getById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
