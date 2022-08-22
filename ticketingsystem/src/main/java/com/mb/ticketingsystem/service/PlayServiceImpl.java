package com.mb.ticketingsystem.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb.ticketingsystem.dao.PlayDao;
import com.mb.ticketingsystem.entity.Play;
import com.mb.ticketingsystem.exception.CustomException;
import com.mb.ticketingsystem.exception.ErrorCode;
import com.mb.ticketingsystem.model.PlayModel;
import com.mb.ticketingsystem.repository.PlayRepository;

@Service
public class PlayServiceImpl implements PlayService {
	
	@Autowired
	private PlayDao playDao;
	
	@Autowired
	private PlayRepository playrepository;
	
	@Autowired
	ModelMapper mapper;
	
	@Override
	public List<Play> getAllPlays() {
		try {
			return playDao.getAllTheatres();
		} catch (Exception e) {
			throw new CustomException("empty database", ErrorCode.NOT_FOUND);
		}
	}

	@Override
	public Play savePlay(PlayModel playModel) {
			Play theater =null;
			theater = playrepository.findByName(playModel.getName());
			if(theater == null)
			{
				Play toSave = mapper.map(playModel, Play.class);
				return playDao.saveTheatre(toSave);
			}
			else {
				throw new CustomException(playModel.getName()+" already registered in database",ErrorCode.RESOURCE_ALREADY_EXISTS);
			}
	}

	@Override
	public Play getPlayById(Long id) {
		Play play = null;
		play = playDao.getTheaterById(id);
		if(play==null)
		{
			throw new CustomException("couldnot find the id "+id, ErrorCode.NOT_FOUND);
		}
		else {
			return play;
		}
	}

}
