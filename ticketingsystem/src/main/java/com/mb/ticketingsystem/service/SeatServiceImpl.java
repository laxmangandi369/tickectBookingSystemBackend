package com.mb.ticketingsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb.ticketingsystem.dao.SeatDao;
import com.mb.ticketingsystem.exception.CustomException;
import com.mb.ticketingsystem.exception.ErrorCode;
import com.mb.ticketingsystem.model.SeatModel;

@Service
public class SeatServiceImpl implements SeatService{
		
	@Autowired
	SeatDao seatDao;
	
	@Override
	public List<SeatModel> getListOfSeats(Long showId) {
		List<SeatModel> listOfSeats = null;
			listOfSeats=seatDao.getListOfSeats(showId);
			if(listOfSeats==null)
			{
				throw new CustomException("all seats are empty for the show withshow id "+showId, ErrorCode.NOT_FOUND);
			}
			else {
				return listOfSeats;
			}
	}

	@Override
	public List<SeatModel> registerSeat(List<SeatModel> seats) {
		if(seats==null)
		{
			throw new CustomException("you have not provided any seats to register",ErrorCode.BAD_REQUEST);
		}
		return seatDao.reserveSeat(seats);
	}

}
