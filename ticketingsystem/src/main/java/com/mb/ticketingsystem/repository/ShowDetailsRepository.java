package com.mb.ticketingsystem.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mb.ticketingsystem.entity.Movie;
import com.mb.ticketingsystem.entity.ShowDetail;

@Repository
public interface ShowDetailsRepository extends JpaRepository<ShowDetail,Long> {
	
	@Transactional
	@Modifying
	@Query(value="SELECT DISTINCT(movie) FROM movieshow WHERE movieid = :movieid " , nativeQuery = true)
	List<Movie> findAllByMovieId(@Param("movieid") Long movieid);


	@Transactional
	@Modifying
	@Query(value="select * from movieshow where movieid = :movieid " , nativeQuery = true)
	List<ShowDetail> findAllByDateAndMovieid(@Param("movieid") Integer movieid);
}
