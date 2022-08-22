package com.mb.ticketingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mb.ticketingsystem.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
	Movie findMovieByName(String name);
}
