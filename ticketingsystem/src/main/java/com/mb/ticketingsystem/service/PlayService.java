package com.mb.ticketingsystem.service;

import java.util.List;

import com.mb.ticketingsystem.entity.Play;
import com.mb.ticketingsystem.model.PlayModel;

public interface PlayService {
	List<Play> getAllPlays();
	Play savePlay(PlayModel theaterModel);
	Play getPlayById(Long id);
}
