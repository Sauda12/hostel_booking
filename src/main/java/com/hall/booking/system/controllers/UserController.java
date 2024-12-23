package com.hall.booking.system.controllers;

import com.hall.booking.system.models.User;
import com.hall.booking.system.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerCustomer(@RequestBody User user) {
        User newUser = userService.registerNewCustomer(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }


    @PostMapping("/add-user")
    public ResponseEntity<User> addNewUser(@RequestBody User user) {
        User newUser = userService.addNewUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }


    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> allUsers = userService.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }


    @PutMapping("/update/{userId}")
    public ResponseEntity<User> registerCustomer(@RequestBody User user, @PathVariable long userId) {
        User updateUser = userService.updateUser(user, userId);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }


    @GetMapping("/{userId}")
    public ResponseEntity<User> findUserByUserId(@PathVariable long userId) {
        User user = userService.findUserByUserId(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @DeleteMapping("/{userId}")
    public ResponseEntity<User> deleteUser(@PathVariable long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/totalCustomers")
    public ResponseEntity<Integer> getTotalCustomers() {
        Integer totalCustomers = userService.getTotalCustomers();
        return new ResponseEntity<>(totalCustomers, HttpStatus.OK);
    }

    @GetMapping("/totalUsers")
    public ResponseEntity<Integer> getTotalUsers() {
        Integer totalUsers = userService.getTotalUsers();
        return new ResponseEntity<>(totalUsers, HttpStatus.OK);
    }
}
