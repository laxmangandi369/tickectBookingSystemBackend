package com.mb.ticketingsystem.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb.ticketingsystem.dao.BookingDao;
import com.mb.ticketingsystem.dao.MovieDao;
import com.mb.ticketingsystem.entity.Booking;
import com.mb.ticketingsystem.entity.Movie;
import com.mb.ticketingsystem.entity.Seat;
import com.mb.ticketingsystem.exception.CustomException;
import com.mb.ticketingsystem.exception.ErrorCode;
import com.mb.ticketingsystem.model.BookingModel;
import com.mb.ticketingsystem.model.SeatModel;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingDao bookingDao;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private MovieDao movieDao;

	@Autowired
	private SeatService seatService;

	@Override
	public List<Booking> getAllBookings() {
		List<Booking> allBookings = null;
		allBookings = bookingDao.getAllBooking();
		if (allBookings == null) {
			throw new CustomException("no bookings found", ErrorCode.NOT_FOUND);
		} else {
			return allBookings;
		}
	}

	@Override
	public Booking addBooking(BookingModel bookingModel) {
		Movie movie = null;
		movie = movieDao.getMovieById(bookingModel.getMovieId());
		if (movie == null) {
			throw new CustomException("movie with movie Id " + bookingModel.getMovieId() + " not available",
					ErrorCode.NOT_FOUND);
		}

//		Seat[] seat = new Seat[bookingModel.getSeatNumbers().length];
//		for (int i = 0; i < bookingModel.getSeatNumbers().length; i++) {
//			Seat singleSeat = null;
//			singleSeat = seatService.getSeatBySeatNumber(bookingModel.getSeatNumbers()[i]);
//			if (singleSeat.getSeatNumber() == null) {
//				SeatModel seatModel = new SeatModel();
//				seatModel.setIsBooked(true);
//				seatModel.setMovieId(bookingModel.getMovieId());
//				seatModel.setSeatNumber(bookingModel.getSeatNumbers()[i]);
//
//				seat[i] = seatService.reserveSeat(seatModel);
//
//			}
//		}

		Booking toAddBooking= new Booking();
//		toAddBooking = mapper.map(bookingModel, Booking.class);
		toAddBooking.setCustomerName(bookingModel.getCustomerName());
		toAddBooking.setEmail(bookingModel.getEmail());
		toAddBooking.setBookingSeats(bookingModel.getBookingSeats());
//		toAddBooking.setSeats(seat);
		toAddBooking.setMovie(movie);

		return bookingDao.addBooking(toAddBooking);
	}

	@Override
	public List<Booking> getReservdSeats(Long movidId) {
		List<Booking> reservedSeats = null;

		reservedSeats = bookingDao.getReservedSeats(movidId);
		if (reservedSeats != null) {
			return reservedSeats;
		} else {
			throw new CustomException("no reserved seats found ", ErrorCode.NOT_FOUND);
		}
	}

	@Override
	public List<Booking> getReservedSeatsDesc(Long movieId) {
		List<Booking> reversedSeat=null;
		reversedSeat = bookingDao.GetReservedSeatsDesc(movieId);
		if(reversedSeat !=null)
		{
			return reversedSeat;
		}
		else
		{
			throw new CustomException("no reserved seat found", ErrorCode.NOT_FOUND);
		}
	}

}
