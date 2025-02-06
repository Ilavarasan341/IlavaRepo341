package com.express.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.express.model.Admin;
import com.express.model.Customer;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer> {

	@Query("select Count(a) from Admin a where a.emailId=:emailId")
	int countByEmail(@Param("emailId") String emailId);

	@Query("select Count(a) from Admin a where a.password=:password")
	int countPassword(@Param("password") long password);

	Optional<Admin> findByEmailId(String emailId);

}
