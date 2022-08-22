package com.mb.ticketingsystem.service;

import java.util.List;

import com.mb.ticketingsystem.entity.City;

public interface CityService {
	List<City> getAllCities();
	City getCityByName(String name);
}
