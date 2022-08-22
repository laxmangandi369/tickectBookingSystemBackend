package com.mb.ticketingsystem.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb.ticketingsystem.entity.Movie;
import com.mb.ticketingsystem.entity.Screen;
import com.mb.ticketingsystem.entity.Seat;
import com.mb.ticketingsystem.entity.ShowDetail;
import com.mb.ticketingsystem.exception.CustomException;
import com.mb.ticketingsystem.exception.ErrorCode;
import com.mb.ticketingsystem.model.ShowDetailsModel;
import com.mb.ticketingsystem.repository.MovieRepository;
import com.mb.ticketingsystem.repository.ScreenRepository;
import com.mb.ticketingsystem.repository.SeatRepository;
import com.mb.ticketingsystem.repository.ShowDetailsRepository;

@Service
public class ShowDetailsDaoImpl implements ShowDetailsDao {

	@Autowired
	private ShowDetailsRepository showDetailsRepository;
	
	@Autowired
	private ScreenRepository screenRepository;
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private SeatRepository seatRepository;
	
	@Override
	public List<Movie> searchShowByMovie(Long movieId) {
		try {
			return showDetailsRepository.findAllByMovieId(movieId);
		} catch (Exception e) {
		   throw new CustomException("error while reteriving movies", ErrorCode.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public List<ShowDetailsModel> addShow(List<ShowDetailsModel> showDetails) {
		for(ShowDetailsModel show: showDetails) {
			ShowDetail movieShow = new ShowDetail();
			
			movieShow.setPrice(show.getPrice());
			movieShow.setStartTime(show.getStartTime());
			
			
			Screen screen = screenRepository.findById(show.getScreenid()).get();
			Movie movie = movieRepository.findById(show.getMovieId()).get();
			
			movieShow.setScreen(screen);
			movieShow.setMovie(movie);
			
			 ShowDetail showDetail = showDetailsRepository.save(movieShow);
			
			 
			 for(int i=1;i<=screen.getTotalSeats(); i++)
			 {
				 Seat seat = new Seat();
				 seat.setSeatNo(i);
				 seat.setScreen(screen);
				 seat.setShowDetail(showDetail);
				 
				 seatRepository.save(seat);
			 }
			
		}
		return showDetails;
	}

}
