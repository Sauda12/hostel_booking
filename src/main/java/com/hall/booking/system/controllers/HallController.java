package com.hall.booking.system.controllers;

import com.hall.booking.system.models.Hall;
import com.hall.booking.system.services.HallService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/halls")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class HallController {
    private final HallService hallService;

    @PostMapping("/create")
    public ResponseEntity<Hall> createHall(@RequestBody Hall hall) {
        Hall newHall = hallService.createHall(hall);
        return new ResponseEntity<>(newHall, HttpStatus.CREATED);
    }



    @GetMapping("/all")
    public ResponseEntity<List<Hall>> getAllHalls() {
        List<Hall> halls = hallService.getAllHalls();
        return new ResponseEntity<>(halls, HttpStatus.OK);
    }

    @GetMapping("/{hallId}")
    public ResponseEntity<Hall> findHallById(@PathVariable long hallId) {
        Hall hall = hallService.findHallById(hallId);
        return new ResponseEntity<>(hall, HttpStatus.OK);
    }


    @PutMapping("/update/{hallId}")
    public ResponseEntity<Hall> updateHall(@RequestBody Hall hall, @PathVariable long hallId) {
        Hall newHall = hallService.updateHall(hall, hallId);
        return new ResponseEntity<>(newHall, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{hallId}")
    public ResponseEntity<?> deleteHall(@PathVariable long hallId) {
        hallService.deleteHall(hallId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/totalHalls")
    public ResponseEntity<Integer> getTotalHalls() {
        Integer totalHalls = hallService.getTotalHalls();
        return new ResponseEntity<>(totalHalls, HttpStatus.OK);
    }
}
