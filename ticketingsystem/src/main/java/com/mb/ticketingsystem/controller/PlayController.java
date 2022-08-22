package com.mb.ticketingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mb.ticketingsystem.model.SuccessResponse;
import com.mb.ticketingsystem.service.PlayService;
import com.mb.ticketingsystem.model.PlayModel;

@RestController
@RequestMapping("api/play")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PlayController {
	@Autowired
	PlayService playService;
	
	@GetMapping
	public ResponseEntity<SuccessResponse> getAllTheater()
	{
		SuccessResponse response = new SuccessResponse();
		response.setData(playService.getAllPlays());
		response.setMessage("all the theater's available");
		response.setSuccessCode(HttpStatus.OK.value());
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<SuccessResponse> saveTheater(@RequestBody PlayModel theaterModel)
	{
		SuccessResponse response = new SuccessResponse();
		response.setData(playService.savePlay(theaterModel));
		response.setMessage("successfully saved");
		response.setSuccessCode(HttpStatus.OK.value());
		
		return new ResponseEntity<>(response,HttpStatus.OK);

	}
}
