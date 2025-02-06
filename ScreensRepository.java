package com.express.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.express.model.Screens;

@Repository
public interface ScreensRepository extends JpaRepository<Screens, Integer> {

	@Query(" SELECT  COUNT(s)> 0 from Screens s where s.screenName=:screenName")
	boolean existsByName(String screenName);

    @Query("SELECT s FROM Screens s WHERE s.screenName = :screenName AND s.screenId <> :screenId")
	Optional<Screens> findByScreenNameAndIdNot(@Param("screenName") String screenName,@Param("screenId") int screenId);
	
}

