package com.mb.ticketingsystem.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb.ticketingsystem.entity.City;
import com.mb.ticketingsystem.exception.CustomException;
import com.mb.ticketingsystem.exception.ErrorCode;
import com.mb.ticketingsystem.repository.CityRepoository;

@Service
public class CityDaoImpl implements CityDao {

	@Autowired
	private CityRepoository cityRepoository;
	
	@Override
	public City getCityByName(String name) {
		try {
		  return cityRepoository.findBycityName(name);
		}catch (Exception e) {
			throw new CustomException("error while reteriving city data",ErrorCode.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public List<City> getAllCities() {
		try {
			return cityRepoository.findAll();
		} catch (Exception e) {
			throw new CustomException("error while reteriving all city data",ErrorCode.INTERNAL_SERVER_ERROR);
		}
	}
	
}
