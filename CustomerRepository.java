package com.express.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.express.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	@Query("select Count(c) from Customer c where c.emailId=:emailId")
	int countByEmail(@Param("emailId") String emailId);

	@Query("select Count(c) from Customer c where c.mobile=:mobile")
	int countByMobile(@Param("mobile") long mobile);

	@Query("select Count(c) from Customer c where c.password=:password")
	int countByPassword(@Param("password") String password);

	Optional<Customer> findByEmailId(String emailId); 
	
}
