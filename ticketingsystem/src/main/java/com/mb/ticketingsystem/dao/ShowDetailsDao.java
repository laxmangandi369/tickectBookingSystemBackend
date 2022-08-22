package com.mb.ticketingsystem.dao;

import java.util.List;

import com.mb.ticketingsystem.entity.Movie;
import com.mb.ticketingsystem.model.ShowDetailsModel;

public interface ShowDetailsDao {
	public List<Movie> searchShowByMovie(Long movieId);
	public List<ShowDetailsModel> addShow(List<ShowDetailsModel> showDetails);
	
	
}
