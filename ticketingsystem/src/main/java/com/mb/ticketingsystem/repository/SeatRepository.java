package com.mb.ticketingsystem.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mb.ticketingsystem.entity.Seat;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {

	
	@Transactional
	@Modifying
	@Query(value="UPDATE seat SET isbooked = true WHERE seatid = :seatid" , nativeQuery = true)
	void bookSeat(@Param("seatid") Integer seatId);
	
	Seat findSeatBySeatNumber(String seatNumber);
}
