package com.mb.ticketingsystem.dao;

import java.util.List;

import com.mb.ticketingsystem.entity.Booking;
import com.mb.ticketingsystem.entity.Seat;

public interface BookingDao {

	public List<Booking> getAllBooking();
	public Booking addBooking(Booking booking);
	public List<Booking> getReservedSeats(Long movieId);
	public List<Seat> testGetReservedSeats(Long movieId);
}
