package com.mb.ticketingsystem.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb.ticketingsystem.dao.MovieDao;
import com.mb.ticketingsystem.entity.Movie;
import com.mb.ticketingsystem.exception.CustomException;
import com.mb.ticketingsystem.exception.ErrorCode;
import com.mb.ticketingsystem.model.MovieModel;
import com.mb.ticketingsystem.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	MovieDao movieDao;
	
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	ModelMapper mapper;
	
	@Override
	public List<Movie> getAllMovies() {
		
		List<Movie> allMovies = movieDao.getAllMovies();
		if(allMovies==null)
		{
			throw new CustomException("empty database", ErrorCode.NOT_FOUND);
		}
		else {
			return allMovies;
		}
	}

	@Override
	public Movie addMovie(MovieModel movieModel) {
		Movie movie = null;
		movie = movieRepository.findMovieByName(movieModel.getName());
		
		if(movie == null)
		{
			Movie addMovie = mapper.map(movieModel, Movie.class);
			return movieDao.addMovie(addMovie);
		}
		else {
			throw new CustomException("movie with name "+movieModel.getName()+" already exists",ErrorCode.RESOURCE_ALREADY_EXISTS);
		}
	}

	@Override
	public Movie getMovieById(Long id) {
		Movie movie =null;
		movie = movieDao.getMovieById(id);
		
		if(movie==null)
		{
			throw new CustomException("movie with id "+id+" is not available",ErrorCode.NOT_FOUND);
		}
		else {
			return movie;
		}
	}

}
