package com.express.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.express.model.Screens;
import com.express.model.ShowDetails;

@Repository
public interface ShowDetailRepository extends JpaRepository<ShowDetails, Integer> {

	@Query("select d from ShowDetails d where d.showDate =:date")
	List<ShowDetails> findByDate(@Param("date") LocalDate date);

	@Query("SELECT showTime from ShowDetails")
	List<LocalTime> countTime();
	

}
