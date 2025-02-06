package com.express.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.express.model.Movies;

@Repository
public interface MoviesRepository extends JpaRepository<Movies, Integer> {

	// count total result and check 
	@Query("SELECT COUNT(m) > 0 FROM Movies m WHERE LOWER(TRIM(m.movieName)) = LOWER(TRIM(:movieName))")
	boolean existsByName (@Param("movieName")  String movieName);
	
}
