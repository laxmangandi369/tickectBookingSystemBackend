package com.mb.ticketingsystem.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb.ticketingsystem.entity.Booking;
import com.mb.ticketingsystem.exception.CustomException;
import com.mb.ticketingsystem.exception.ErrorCode;
import com.mb.ticketingsystem.repository.BookingRepository;

@Service
public class BookingDaoImpl implements BookingDao {

	@Autowired
	private BookingRepository bookingRepository;

	@Override
	public List<Booking> getAllBooking() {
		try {
			return bookingRepository.findAll();
		} catch (Exception e) {
			throw new CustomException("error while reteriving booking details", ErrorCode.INTERNAL_SERVER_ERROR);

		}
	}

	@Override
	public Booking addBooking(Booking booking) {
		try {
			return bookingRepository.save(booking);
		} catch (Exception e) {
			throw new CustomException("error while booking with booking id " + booking.getBookingId(),
					ErrorCode.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public List<Booking> getReservedSeats(Long movieId) {
		try {
			return bookingRepository.findReservedSeats(movieId);
		} catch (Exception e) {
			throw new CustomException("error while retrivig the reserved seats for movieId " + movieId,
					ErrorCode.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public List<Booking> GetReservedSeatsDesc(Long movieId) {
		try {
			return bookingRepository.findAllOrderByIdDesc(movieId);
		}
		catch (Exception e) {
			throw new CustomException("error while retriving descending seat data", ErrorCode.INTERNAL_SERVER_ERROR);
		}
	}

	

}
