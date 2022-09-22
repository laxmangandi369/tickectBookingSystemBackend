package com.mb.ticketingsystem.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mb.ticketingsystem.model.BookingModel;
import com.mb.ticketingsystem.model.SuccessResponse;
import com.mb.ticketingsystem.service.BookingService;

@RestController
@RequestMapping("api/booking")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping
	public ResponseEntity<SuccessResponse> getAllBookings() {
		SuccessResponse response = new SuccessResponse();
		response.setData(bookingService.getAllBookings());
		response.setMessage("all bookings");
		response.setSuccessCode(HttpStatus.OK.value());

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	@PostMapping
	public ResponseEntity<SuccessResponse> bookTickets(@RequestBody @Valid BookingModel bookingModel) {
		SuccessResponse response = new SuccessResponse();
		response.setData(bookingService.addBooking(bookingModel));
		response.setMessage("booking successfull");
		response.setSuccessCode(HttpStatus.OK.value());

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	@GetMapping("/{id}")
	public ResponseEntity<SuccessResponse> getReservedSeats(@PathVariable Long id) {
		SuccessResponse response = new SuccessResponse();
		response.setData(bookingService.getReservdSeats(id));
		response.setMessage("all reserved seats for movie id " + id);
		response.setSuccessCode(HttpStatus.OK.value());

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	@GetMapping("desc/{id}")
	public ResponseEntity<SuccessResponse> getReservedSeatsDesc(@PathVariable Long id) {
		SuccessResponse response = new SuccessResponse();
		response.setData(bookingService.getReservedSeatsDesc(id));
		response.setMessage("all reserved seats for movie id in descending order " + id);
		response.setSuccessCode(HttpStatus.OK.value());

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	
}
