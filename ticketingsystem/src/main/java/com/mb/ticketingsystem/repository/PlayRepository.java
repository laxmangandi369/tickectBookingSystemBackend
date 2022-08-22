package com.mb.ticketingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mb.ticketingsystem.entity.Play;

@Repository
public interface PlayRepository extends JpaRepository<Play,Long> {
	Play findByName(String name);

}
