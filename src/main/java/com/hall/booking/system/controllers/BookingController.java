package com.hall.booking.system.controllers;

import com.hall.booking.system.models.Booking;
import com.hall.booking.system.models.Hall;
import com.hall.booking.system.services.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;


    @PostMapping("/book/customer/{customerId}/hall/{hallId}")
    public ResponseEntity<Booking> makeHallBooking(@PathVariable long customerId, @PathVariable long hallId) {
        Booking booking = bookingService.makeHallBooking(customerId, hallId);
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }


    @GetMapping("/all")
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> allBookings = bookingService.getAllBookings();
        return new ResponseEntity<>(allBookings, HttpStatus.OK);
    }


    @GetMapping("/all/customer/{username}")
    public ResponseEntity<List<Booking>> getAllBookings(@PathVariable String username) {
        List<Booking> allBookings = bookingService.getAllBookingsByCustomerUsername(username);
        return new ResponseEntity<>(allBookings, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Booking> findBookingById(@PathVariable long id) {
        Booking booking = bookingService.findBookingById(id);
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBooking(@PathVariable long id) {
        bookingService.deleteBooking(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/totalBookings")
    public ResponseEntity<Integer> getTotalBookings() {
        Integer totalBookings = bookingService.getTotalBookings();
        return new ResponseEntity<>(totalBookings, HttpStatus.OK);
    }
}
