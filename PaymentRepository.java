package com.express.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.express.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

	@Query("SELECT booking from Payment")
	Optional<Payment> findByBookingId(int bookingId);

	

}
