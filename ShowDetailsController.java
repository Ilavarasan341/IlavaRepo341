package com.express.controller;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RestController;
import com.express.modelDTO.ShowDetailsDTO;
import com.express.service.ShowDetailsService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PutMapping;



@CrossOrigin
@RestController
public class ShowDetailsController {
	
	@Autowired
	private ShowDetailsService showDetailsService;
	
	@PostMapping("show/{moviesId}/show/{screenId}")
	
	public Object createshow(@PathVariable int moviesId,@PathVariable int screenId,@RequestBody ShowDetailsDTO showDetailsDTO) {		
		return showDetailsService.addShow(moviesId,screenId,showDetailsDTO);
	}
	
	@GetMapping("fetch/{date}")
	public Object getByDate( @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date){
		return (showDetailsService.getByDate(date));
		
	}
	
	@GetMapping("allMovies")
	public Object getAllMovies() {
		return showDetailsService.getAllMovies();
	}	
	
	@PutMapping("update/{showId}/{moviesId}/{screenId}")
	public Object updateShow(@PathVariable int showId ,@PathVariable int moviesId,@PathVariable int screenId,@RequestBody ShowDetailsDTO dto) {	
		return showDetailsService.updateShows(showId,moviesId,screenId,dto);
	}
}
