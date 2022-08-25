package com.mb.ticketingsystem.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb.ticketingsystem.entity.Play;
import com.mb.ticketingsystem.exception.CustomException;
import com.mb.ticketingsystem.exception.ErrorCode;
import com.mb.ticketingsystem.repository.PlayRepository;

@Service
public class PlayDaoImpl implements PlayDao {

	@Autowired
	private PlayRepository theatreRepository;

	@Override
	public List<Play> getAllTheatres() {
		try {
			return theatreRepository.findAll();
		} catch (Exception e) {
			throw new CustomException("error while retreving data", ErrorCode.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public Play saveTheatre(Play theater) {
		try {
			return theatreRepository.save(theater);
		} catch (Exception e) {
			throw new CustomException("Error while saving the data", ErrorCode.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public Play getTheaterById(Long id) {
		try {
			return theatreRepository.findById(id).get();
		} catch (Exception e) {
			throw new CustomException("cannot retrive id " + id + " from database", ErrorCode.INTERNAL_SERVER_ERROR);
		}
	}

}
