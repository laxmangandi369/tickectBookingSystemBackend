package com.mb.ticketingsystem.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb.ticketingsystem.entity.Movie;
import com.mb.ticketingsystem.exception.CustomException;
import com.mb.ticketingsystem.exception.ErrorCode;
import com.mb.ticketingsystem.repository.MovieRepository;

@Service
public class MovieDaoImpl implements MovieDao {

	@Autowired
	MovieRepository movieRepository;
	
	@Override
	public List<Movie> getAllMovies() {
		try {
			return movieRepository.findAll();
		} catch (Exception e) {
			throw new CustomException("error in reteriving movies from database", ErrorCode.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public Movie addMovie(Movie movie) {
		try {
			return movieRepository.save(movie);
		} catch (Exception e) {
			throw new CustomException("error while saving movie in database",ErrorCode.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public Movie getMovieById(Long id) {
		try {
			return movieRepository.findById(id).get();
		} catch (Exception e) {
			throw new CustomException("error while fetching movie with id "+id, ErrorCode.INTERNAL_SERVER_ERROR);
		}
	}

}
