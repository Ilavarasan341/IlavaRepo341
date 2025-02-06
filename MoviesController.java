package com.express.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.express.modelDTO.MoviesDTO;
import com.express.service.MoviesService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@CrossOrigin
@RestController
public class MoviesController {

	Map<String, Object> map = new HashMap<String, Object>();

	@Autowired
	private MoviesService moviesService;

	@PostMapping("create/movies")
	public Object createMovie(@RequestBody MoviesDTO moviesDTO) {
		return (moviesService.createMovie(moviesDTO));
	}

	@GetMapping("fetch/movies")
	public Object getAllProduct() {
		return moviesService.showAllMovies();
	}

	@DeleteMapping("/delete/movie/{moviesId}")
	public Object deleteMovies(@PathVariable int moviesId) {
		try {
			moviesService.deleteMovie(moviesId);
			map.put("status", "Deleted");
			map.put("message", "movie deleted successfully");
			return map;
		} catch (DataIntegrityViolationException e) {
			// Foreign key violation
			map.put("status", "error");
			map.put("message", "Movie is asgined to Screen can not delete");
			return map;
		} catch (Exception e) {
			// Handle any other exception
			map.put("message", "An unexpected error occurred while deleting the resource.");
			return map;
		}
	}

	@PutMapping("update/{moviesId}")

	public Object putMethodName(@PathVariable int moviesId, @RequestBody MoviesDTO moviesDTO) {
		return (moviesService.updateMovie(moviesId, moviesDTO));

	}

}
