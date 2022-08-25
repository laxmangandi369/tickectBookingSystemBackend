package com.mb.ticketingsystem.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb.ticketingsystem.dao.SeatDao;
import com.mb.ticketingsystem.entity.Movie;
import com.mb.ticketingsystem.entity.Seat;
import com.mb.ticketingsystem.exception.CustomException;
import com.mb.ticketingsystem.exception.ErrorCode;
import com.mb.ticketingsystem.model.SeatModel;

@Service
public class SeatServiceImpl implements SeatService {

	@Autowired
	private SeatDao seatDao;

	@Autowired
	private MovieService movieService;

	@Autowired
	private ModelMapper mapper;

	@Override
	public List<Seat> getAllSeats() {
		List<Seat> allseats = null;
		allseats = seatDao.getListOfSeats();
		if (allseats == null) {
			throw new CustomException("no seats found", ErrorCode.NOT_FOUND);
		} else {
			return allseats;
		}
	}

	@Override
	public Seat reserveSeat(SeatModel model) {

		Seat isRegistered = seatDao.getSeatBySeatNumber(model.getSeatNumber());
		if (isRegistered != null) {
			throw new CustomException("already booked", ErrorCode.RESOURCE_ALREADY_EXISTS);
		}

		Seat seat = mapper.map(model, Seat.class);

		Movie movie = movieService.getMovieById(model.getMovieId());
		seat.setMovie(movie);
		return seatDao.reserveSeats(seat);
	}

	@Override
	public Seat getSeatBySeatNumber(String SeatNumber) {
		Seat seat = null;
		seat = seatDao.getSeatBySeatNumber(SeatNumber);
		if (seat == null) {
			return new Seat();
		} else {
			throw new CustomException("seat number " + SeatNumber + " alreadyexists", ErrorCode.NOT_FOUND);
		}
	}

}
