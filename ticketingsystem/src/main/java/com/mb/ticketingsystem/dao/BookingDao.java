package com.mb.ticketingsystem.dao;

import java.util.List;

import com.mb.ticketingsystem.entity.Booking;

public interface BookingDao {

	public List<Booking> getAllBooking();
	public Booking addBooking(Booking booking);
	public List<Booking> getReservedSeats(Long movieId);
	public List<Booking> GetReservedSeatsDesc(Long movieId);
}
