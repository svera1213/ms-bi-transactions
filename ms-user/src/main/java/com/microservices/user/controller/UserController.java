package com.microservices.user.controller;

import com.microservices.user.entities.User;
import com.microservices.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void saveUser(@RequestBody User user){
        userService.save(user);
    }

    @GetMapping()
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(userService.findById(id));
    }

    @GetMapping("/NUI/{nationalId}")
    public ResponseEntity<?> findByNationalId(@PathVariable Long nationalId){
        return ResponseEntity.ok(userService.findByNationalId(nationalId));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<?> findByEmail(@PathVariable String email){
        return ResponseEntity.ok(userService.findByEmail(email));
    }
}
