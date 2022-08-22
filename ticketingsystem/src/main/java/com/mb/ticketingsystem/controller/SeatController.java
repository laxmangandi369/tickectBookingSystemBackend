package com.mb.ticketingsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mb.ticketingsystem.model.SeatModel;
import com.mb.ticketingsystem.model.ShowDetailsDummyModel;
import com.mb.ticketingsystem.model.SuccessResponse;
import com.mb.ticketingsystem.service.SeatService;

@RestController
@RequestMapping("api/seats")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SeatController {

	
	@Autowired
	SeatService seatService;
	
	@PostMapping
	public ResponseEntity<SuccessResponse> getAllSeats(@RequestBody ShowDetailsDummyModel detailsDummyModel)
	{
		SuccessResponse response = new SuccessResponse();
		response.setData(seatService.getListOfSeats(detailsDummyModel.getShowId()));
		response.setMessage("list of seats for the booking");
		response.setSuccessCode(HttpStatus.OK.value());
		
		return new ResponseEntity<>(response,HttpStatus.OK);

	}
	
	@PostMapping("/setseat")
	public ResponseEntity<SuccessResponse> selectSeat(@RequestBody List<SeatModel> seats)
	{
		SuccessResponse response = new SuccessResponse();
		response.setData(seatService.registerSeat(seats));
		response.setMessage("successfully saved the seats");
		response.setSuccessCode(HttpStatus.OK.value());
		
		return new ResponseEntity<>(response,HttpStatus.OK);

	}
	
}
