package com.hall.booking.system.services;

import com.hall.booking.system.models.User;
import com.hall.booking.system.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    public User registerNewCustomer(User user) {
        user.setRole("ROLE_CUSTOMER");
        return userRepository.save(user);
    }


    public User addNewUser(User user) {
        return userRepository.save(user);
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    public Integer getTotalUsers() {
        return userRepository.getTotalUsers();
    }


    public Integer getTotalCustomers() {
        return userRepository.getAllCustomers();
    }



    public User findUserByUsername(String username, String password) {
        User user = userRepository.findUserByUsernameAndPassword(username, password);
        if (user == null) {
            throw new RuntimeException("User not found !");
        }

        return user;
    }

    public User findUserByUserId(long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found !"));
    }


    public User updateUser(User user, long userId) {
        User updateUser = findUserByUserId(userId);
        updateUser.setFirstName(user.getFirstName());
        updateUser.setSecondName(user.getSecondName());
        updateUser.setLastName(user.getLastName());
        updateUser.setUsername(user.getUsername());
        updateUser.setPhoneNumber(user.getPhoneNumber());
        return userRepository.save(updateUser);
    }

    public void deleteUser(long userId) {
        User user = findUserByUserId(userId);
        userRepository.deleteById(user.getUserId());
    }
}
