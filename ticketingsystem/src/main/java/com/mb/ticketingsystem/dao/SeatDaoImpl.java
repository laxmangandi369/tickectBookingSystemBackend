package com.mb.ticketingsystem.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb.ticketingsystem.entity.Seat;
import com.mb.ticketingsystem.exception.CustomException;
import com.mb.ticketingsystem.exception.ErrorCode;
import com.mb.ticketingsystem.repository.SeatRepository;

@Service
public class SeatDaoImpl implements SeatDao {

	@Autowired
	private SeatRepository seatRepository;

	@Override
	public List<Seat> getListOfSeats() {
		try {
			return seatRepository.findAll();
		} catch (Exception e) {
			throw new CustomException("error while getting all seats", ErrorCode.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public Seat reserveSeats(Seat seat) {
		try {
			return seatRepository.save(seat);
		} catch (Exception e) {
			throw new CustomException("error while savinng seatNumber " + seat.getSeatNumber(),
					ErrorCode.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public Seat getSeatBySeatNumber(String seatNumber) {
		try {
			return seatRepository.findSeatBySeatNumber(seatNumber);
		} catch (Exception e) {
			throw new CustomException("error while finding seatNumber" + seatNumber, ErrorCode.INTERNAL_SERVER_ERROR);
		}
	}

}
