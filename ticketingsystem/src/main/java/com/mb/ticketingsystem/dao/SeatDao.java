package com.mb.ticketingsystem.dao;

import java.util.List;

import com.mb.ticketingsystem.entity.Seat;

public interface SeatDao {

	public List<Seat> getListOfSeats();
	public Seat reserveSeats(Seat seat);
	public Seat getSeatBySeatNumber(String seatNumber);
}
