package com.express.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.express.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
