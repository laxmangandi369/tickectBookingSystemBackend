package com.mb.ticketingsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb.ticketingsystem.dao.ShowDetailsDao;
import com.mb.ticketingsystem.entity.Movie;
import com.mb.ticketingsystem.exception.CustomException;
import com.mb.ticketingsystem.exception.ErrorCode;
import com.mb.ticketingsystem.model.ShowDetailsModel;

@Service
public class ShowDetailsServiceImpl implements ShowDetailService {

	@Autowired
	ShowDetailsDao showDetailsDao;
	
	@Override
	public List<Movie> searchShowByMovie(Long movieId) {
		List<Movie> movies =null;
		movies = showDetailsDao.searchShowByMovie(movieId);
		if(movies==null)
		{
			throw new CustomException("no movies found with movie id "+movieId, ErrorCode.NOT_FOUND);
		}
		else {
			return movies;
		}
	}

	@Override
	public List<ShowDetailsModel> addShow(List<ShowDetailsModel> showDetails) {
		List<ShowDetailsModel> showDetailsModels = null;
		showDetailsModels = showDetailsDao.addShow(showDetailsModels);
		
		if(showDetailsModels==null)
		{
			throw new CustomException("no details of the show available",ErrorCode.NOT_FOUND);
		}
		else {
			return showDetailsModels;
		}
	}

}
