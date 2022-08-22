package com.mb.ticketingsystem.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mb.ticketingsystem.model.MovieModel;
import com.mb.ticketingsystem.model.SuccessResponse;
import com.mb.ticketingsystem.service.MovieService;

@RestController
@RequestMapping("api/movie")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MovieController {
	
	@Autowired
	MovieService movieService;
	
	@GetMapping
	public ResponseEntity<SuccessResponse> getAllMovies()
	{
		SuccessResponse response = new SuccessResponse();
		response.setData(movieService.getAllMovies());
		response.setMessage("All available movies");
		response.setSuccessCode(HttpStatus.OK.value());
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<SuccessResponse> saveMovies(@RequestBody MovieModel movieModel)
	{
		SuccessResponse response = new SuccessResponse();
		response.setData(movieService.addMovie(movieModel));
		response.setMessage("saved successfully");
		response.setSuccessCode(HttpStatus.OK.value());
		
		return new ResponseEntity<>(response,HttpStatus.OK);

	}
	@GetMapping("/{id}")
	public ResponseEntity<SuccessResponse> getMovieById(@PathVariable("id") Long id)
	{
		SuccessResponse response = new SuccessResponse();
		response.setData(movieService.getMovieById(id));
		response.setMessage("successfully fetched");
		response.setSuccessCode(HttpStatus.OK.value());
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
}
