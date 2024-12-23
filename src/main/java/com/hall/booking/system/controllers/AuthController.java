package com.hall.booking.system.controllers;

import com.hall.booking.system.models.User;
import com.hall.booking.system.models.dto.LoginRequestDTO;
import com.hall.booking.system.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginRequestDTO requestDTO) {
        User loginUser = userService.findUserByUsername(requestDTO.getUsername(), requestDTO.getPassword());
        return new ResponseEntity<>(loginUser, HttpStatus.OK);
    }
}
