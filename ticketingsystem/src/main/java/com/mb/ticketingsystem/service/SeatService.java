package com.mb.ticketingsystem.service;

import java.util.List;

import com.mb.ticketingsystem.entity.Seat;
import com.mb.ticketingsystem.model.SeatModel;

public interface SeatService {
	public List<Seat> getAllSeats();
	public Seat reserveSeat(SeatModel model);
	public Seat getSeatBySeatNumber(String SeatNumber);
}
