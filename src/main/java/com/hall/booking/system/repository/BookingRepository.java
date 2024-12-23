package com.hall.booking.system.repository;

import com.hall.booking.system.models.Booking;
import com.hall.booking.system.models.Hall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> getAllBookingsByCustomerUsername(String username);

    @Query("SELECT COUNT(*) FROM Booking")
    Integer getTotalBookings();
}
