package com.mb.ticketingsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb.ticketingsystem.dao.CityDao;
import com.mb.ticketingsystem.entity.City;
import com.mb.ticketingsystem.exception.CustomException;
import com.mb.ticketingsystem.exception.ErrorCode;

@Service
public class CityServiceImpl implements CityService {
	
	@Autowired
	CityDao cityDao ;
	
	@Override
	public List<City> getAllCities() {
		List<City> allCities = null;
		allCities = cityDao.getAllCities();
		if(allCities==null)
		{
			throw new CustomException("empty database for cities", ErrorCode.NOT_FOUND);
		}
		else {
			return allCities;
		}
 	}

	@Override
	public City getCityByName(String name) {
		City city = null;
		city = cityDao.getCityByName(name);
		if(city==null)
		{
			throw new CustomException("city with name "+name+" not found", ErrorCode.NOT_FOUND);
		}
		else {
			return city;
		}
	}

}
