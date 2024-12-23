package com.hall.booking.system.services;

import com.hall.booking.system.models.Booking;
import com.hall.booking.system.models.Hall;
import com.hall.booking.system.models.User;
import com.hall.booking.system.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;
    private final HallService hallService;
    private final UserService userService;

    public Booking makeHallBooking(long customerId, long hallId) {
        Booking booking = new Booking();
        User customer = userService.findUserByUserId(customerId);
        Hall hall = hallService.findHallById(hallId);
        booking.setCustomer(customer);
        booking.setHall(hall);
        booking.setDate(LocalDate.now());
        hall.setStatus("Booked");
        booking.setStatus("Booked");
        return bookingRepository.save(booking);
    }


    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }


    public Integer getTotalBookings() {
        return bookingRepository.getTotalBookings();
    }



    public List<Booking> getAllBookingsByCustomerUsername(String username) {
        return bookingRepository.getAllBookingsByCustomerUsername(username);
    }


    public Booking findBookingById(long id) {
        return bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("Booking not found"));
    }


    public void deleteBooking(long id) {
        Booking booking = findBookingById(id);
        bookingRepository.deleteById(booking.getBookingId());
    }
}
