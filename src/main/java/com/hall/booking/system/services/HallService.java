package com.hall.booking.system.services;

import com.hall.booking.system.models.Hall;
import com.hall.booking.system.models.User;
import com.hall.booking.system.repository.HallRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HallService {
    private final HallRepository hallRepository;
    private final UserService userService;

    public Hall createHall(Hall hall) {
        hall.setStatus("Pending");
        return hallRepository.save(hall);
    }


    public List<Hall> getAllHalls() {
        return hallRepository.findAll();
    }


    public Integer getTotalHalls() {
        return hallRepository.getTotalHalls();
    }


    public Hall findHallById(long hallId) {
        return hallRepository.findById(hallId).orElseThrow(() -> new RuntimeException("Hall not found"));
    }

    public Hall updateHall(Hall hall, long hallId) {
        Hall updateHall = findHallById(hallId);
        updateHall.setName(hall.getName());
        updateHall.setAddress(hall.getAddress());
        updateHall.setCapacity(hall.getCapacity());
        updateHall.setPrice(hall.getPrice());
        updateHall.setStatus(hall.getStatus());
        return hallRepository.save(updateHall);
    }


    public void deleteHall(long hallId) {
        Hall hall = findHallById(hallId);
        hallRepository.deleteById(hall.getHallId());
    }


}
