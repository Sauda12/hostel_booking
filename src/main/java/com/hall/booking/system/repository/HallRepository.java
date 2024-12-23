package com.hall.booking.system.repository;

import com.hall.booking.system.models.Hall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HallRepository extends JpaRepository<Hall, Long> {

    @Query("SELECT COUNT(*) FROM Hall")
    Integer getTotalHalls();
}
