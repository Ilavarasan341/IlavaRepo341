package com.express.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.express.model.Screens;
import com.express.modelDTO.ScreensDTO;
import com.express.service.ScreensService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin
@RestController
public class ScreensController {
	
	Map<String, Object> map = new HashMap<String, Object>();


	@Autowired
	private ScreensService screensService;

	@PostMapping("/create/screen")
	public Object addScreen(@RequestBody ScreensDTO screenDTO) {
		return screensService.addScreen(screenDTO);
	}

	@GetMapping("/fetch/screen")
	public Object getAllScreen() {
		return screensService.getAllScreen();
	}

	@DeleteMapping("/delete/screen/{screenId}")
	public Object deleteMovies(@PathVariable int screenId) {
		try {
			screensService.deleteMovie(screenId);
			map.put("status", "success");
			map.put("message", "Screen deleted successfully");
			return map;
		} catch (DataIntegrityViolationException e) {
			// Foreign key violation
			map.put("status", "error");
			map.put("message", "Screen is asgined to movie can not delete.");
			return map;
		} catch (Exception e) {
			// Handle any other exception
			map.put("message", "An unexpected error occurred while deleting the resource.");
			return map;
		}		
	}
	
	@PutMapping("/update/screen/{screenId}")
	public Object updateScreen(@PathVariable int screenId, @RequestBody ScreensDTO screenDTO) {
		return screensService.updateScreen(screenId, screenDTO);
	}
}