package com.mb.ticketingsystem.model;

import javax.validation.constraints.Email;

import org.springframework.lang.NonNull;

public class BookingModel {
	@NonNull
	private String customerName;
	@NonNull
	@Email
	private String email;
	
	private Long movieId;
	
//	private String[] seatNumbers;
	
	private String[] bookingSeats;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

//	public String[] getSeatNumbers() {
//		return seatNumbers;
//	}
//
//	public void setSeatNumbers(String[] seatNumbers) {
//		this.seatNumbers = seatNumbers;
//	}

	public String[] getBookingSeats() {
		return bookingSeats;
	}

	public void setBookingSeats(String[] bookingSeats) {
		this.bookingSeats = bookingSeats;
	}

}
