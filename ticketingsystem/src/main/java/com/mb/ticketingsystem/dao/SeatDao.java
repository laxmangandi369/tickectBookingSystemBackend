package com.mb.ticketingsystem.dao;

import java.util.List;

import com.mb.ticketingsystem.model.SeatModel;

public interface SeatDao {
	public List<SeatModel> getListOfSeats(Long showid);
	public List<SeatModel> reserveSeat(List<SeatModel> seats);
}
