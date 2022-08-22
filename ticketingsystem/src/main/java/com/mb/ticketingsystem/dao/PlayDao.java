package com.mb.ticketingsystem.dao;

import java.util.List;

import com.mb.ticketingsystem.entity.Play;

public interface PlayDao {
	
	List<Play> getAllTheatres();
	
	Play saveTheatre(Play theater);
	Play getTheaterById(Long id);
}
