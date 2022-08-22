package com.mb.ticketingsystem.service;

import java.util.List;

import com.mb.ticketingsystem.entity.Movie;
import com.mb.ticketingsystem.model.MovieModel;

public interface MovieService {
	List<Movie> getAllMovies();
	Movie addMovie(MovieModel movieModel);
	Movie getMovieById(Long id);
}
