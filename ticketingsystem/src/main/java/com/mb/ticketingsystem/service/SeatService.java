package com.mb.ticketingsystem.service;

import java.util.List;

import com.mb.ticketingsystem.model.SeatModel;

public interface SeatService {
	public List<SeatModel> getListOfSeats(Long showId);
	public List<SeatModel> registerSeat(List<SeatModel> seats);
}
