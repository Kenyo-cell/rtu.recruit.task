package rtu.recruit.cotroller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rtu.recruit.services.CheckService;

@RestController
public class CheckController {

    @Autowired
    CheckService checkService;

    @GetMapping(value = "/{userId}/checks")
    public ResponseEntity<?> getAllUserChecks(@PathVariable long userId) {
        try {
            return ResponseEntity.ok(checkService.getAllChecksByUserId(userId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(value = "{userId}/{checkId}")
    public ResponseEntity<?> getAllCheckItems(@PathVariable long userId,
                                              @PathVariable long checkId) {
        try {
            return ResponseEntity.ok(checkService.getAllCheckItemsByCheckId(checkId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> addItemToCheck(@RequestBody String body) throws JsonProcessingException {
        try {
            return ResponseEntity.ok(checkService.addItemToCheckOrCreateCheck(body));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}