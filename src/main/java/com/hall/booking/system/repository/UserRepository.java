package com.hall.booking.system.repository;

import com.hall.booking.system.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsernameAndPassword(String username, String password);

    @Query("SELECT COUNT(*) FROM User c WHERE c.role = 'ROLE_CUSTOMER'")
    Integer getAllCustomers();

    @Query("SELECT COUNT(*) FROM User")
    Integer getTotalUsers();
}
