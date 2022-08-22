package com.mb.ticketingsystem.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb.ticketingsystem.entity.Seat;
import com.mb.ticketingsystem.exception.CustomException;
import com.mb.ticketingsystem.exception.ErrorCode;
import com.mb.ticketingsystem.model.SeatModel;
import com.mb.ticketingsystem.repository.SeatRepository;

@Service
public class SeatDaoImpl implements SeatDao {

	@Autowired
	SeatRepository seatRepository;
	
	@Override
	public List<SeatModel> getListOfSeats(Long showid) {
		try {
			List<Seat> allSeats =  seatRepository.findAllByMovieShow(showid);
			List<SeatModel> showSeats = new ArrayList<>();
			
			for(Seat seat : allSeats)
			{
				SeatModel model = new SeatModel();
				model.setSeatId(seat.getSeatId());
				model.setIsBooked(seat.getIsBooked());
				model.setSeatNumber(seat.getSeatNo());
				
				showSeats.add(model);
			}
			
			return showSeats;
			
		} catch (Exception e) {
			throw new CustomException("error while reteriving list of seats from show id "+showid, ErrorCode.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public List<SeatModel> reserveSeat(List<SeatModel> seats) {
		try {
			Seat toReserve =new Seat();
			
			for(SeatModel seat : seats)
			{
				seatRepository.bookSeat(seat.getSeatId());
				
				toReserve=seatRepository.findById(seat.getSeatId()).get();
			}
			
			List<SeatModel> mySeatList = getListOfSeats(toReserve.getShowDetail().getShowId());
			
			return mySeatList;
			
		} catch (Exception e) {
			throw new CustomException("error in reserving seats",ErrorCode.INTERNAL_SERVER_ERROR);
		}
	}

}
