package com.mb.ticketingsystem.dao;

import java.util.List;

import com.mb.ticketingsystem.entity.City;

public interface CityDao {
	public City getCityByName(String name);
	public List<City> getAllCities();
}
