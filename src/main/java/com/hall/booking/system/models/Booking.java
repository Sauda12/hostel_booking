package com.hall.booking.system.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;
    private LocalDate date;
    private String status;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private User customer;


    @ManyToOne
    @JoinColumn(name = "hall_id")
    private Hall hall;
}
