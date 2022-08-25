package com.mb.ticketingsystem.model;

import javax.validation.constraints.NotBlank;

public class SeatModel {
	@NotBlank
	String seatNumber;
	@NotBlank
	Boolean isBooked;
	@NotBlank
	Long movieId;

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public Boolean getIsBooked() {
		return isBooked;
	}

	public void setIsBooked(Boolean isBooked) {
		this.isBooked = isBooked;
	}

}
