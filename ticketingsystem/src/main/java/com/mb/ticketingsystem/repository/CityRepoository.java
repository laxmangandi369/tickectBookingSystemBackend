package com.mb.ticketingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mb.ticketingsystem.entity.City;

@Repository
public interface CityRepoository extends JpaRepository<City,Long>{
	City findBycityName(String name);
}
