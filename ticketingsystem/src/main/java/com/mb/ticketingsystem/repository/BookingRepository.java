package com.mb.ticketingsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mb.ticketingsystem.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

	@Query(value = "SELECT * FROM ticketingsystem.movie_bookings where movie_id=(?1)", nativeQuery = true)
	List<Booking> findReservedSeats(Long id);
	
	@Query(value = "SELECT * FROM ticketingsystem.movie_bookings where movie_id=(?1) ORDER BY movie_id desc", nativeQuery = true)
	List<Booking> findAllOrderByIdDesc(Long id);
}
