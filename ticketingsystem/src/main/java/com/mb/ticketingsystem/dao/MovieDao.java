package com.mb.ticketingsystem.dao;

import java.util.List;

import com.mb.ticketingsystem.entity.Movie;

public interface MovieDao {
	
	List<Movie> getAllMovies();
	
	Movie addMovie(Movie movie);
	
	Movie getMovieById(Long Id);
	
}
