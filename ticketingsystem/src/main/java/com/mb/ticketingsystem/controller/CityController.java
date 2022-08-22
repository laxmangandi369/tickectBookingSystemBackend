package com.mb.ticketingsystem.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mb.ticketingsystem.model.SuccessResponse;
import com.mb.ticketingsystem.service.CityService;

@RestController
@RequestMapping("api/city")
public class CityController {
	
	@Autowired
	CityService cityService;
	
	
	@GetMapping
	public ResponseEntity<SuccessResponse> getAllCities()
	{
		SuccessResponse response = new SuccessResponse();
		response.setData(cityService.getAllCities());
		response.setMessage("All available cities");
		response.setSuccessCode(HttpStatus.OK.value());
	
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<SuccessResponse> selectCity(@RequestParam String city)
	{
		SuccessResponse response = new SuccessResponse();
		response.setData(cityService.getCityByName(city));
		response.setMessage("city data");
		response.setSuccessCode(HttpStatus.OK.value());
	
		return new ResponseEntity<>(response,HttpStatus.OK);
		
	}

}
