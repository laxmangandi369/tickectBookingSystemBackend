package com.mb.ticketingsystem.service;

import java.util.List;

import com.mb.ticketingsystem.entity.Booking;
import com.mb.ticketingsystem.model.BookingModel;

public interface BookingService {
	
	public List<Booking> getAllBookings();
	public Booking addBooking(BookingModel bookingModel);
	public List<Booking> getReservdSeats(Long movidId);
	public List<Booking> getReservedSeatsDesc(Long movieId);
	
}
