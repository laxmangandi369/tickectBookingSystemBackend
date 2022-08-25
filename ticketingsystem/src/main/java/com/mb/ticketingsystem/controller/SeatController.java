package com.mb.ticketingsystem.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mb.ticketingsystem.model.SeatModel;
import com.mb.ticketingsystem.model.SuccessResponse;
import com.mb.ticketingsystem.service.SeatService;

@RestController
@RequestMapping("api/seats")
public class SeatController {

	
	@Autowired 
	private SeatService seatService;
	
	
	@GetMapping
	public ResponseEntity<SuccessResponse> getAllSeats()
	{
		SuccessResponse response = new SuccessResponse();
		response.setData(seatService.getAllSeats());
		response.setMessage("all seats");
		response.setSuccessCode(HttpStatus.OK.value());
		
		return new ResponseEntity<SuccessResponse>(response,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<SuccessResponse> reserveSeat(@RequestBody @Valid SeatModel seatModel)
	{
		SuccessResponse response = new SuccessResponse();
		response.setData(seatService.reserveSeat(seatModel));
		response.setMessage("seat reserved");
		response.setSuccessCode(HttpStatus.OK.value());
		
		return new ResponseEntity<SuccessResponse>(response,HttpStatus.OK);
	}
}
