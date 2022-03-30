package rtu.recruit.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rtu.recruit.entities.UserEntity;
import rtu.recruit.services.UserService;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(value = "/register")
    public ResponseEntity<?> register(@RequestBody UserEntity user) {
        try {
            userService.register(user);
            return ResponseEntity.ok("its ok");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable long id, @RequestBody UserEntity user) {
        try {
            userService.update(id, user);
            return ResponseEntity.ok("its ok");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        try {
            return ResponseEntity.ok("Deleted: " + userService.deleteById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> get(@PathVariable long id) {
        try {
            return ResponseEntity.ok(userService.getById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }
}
