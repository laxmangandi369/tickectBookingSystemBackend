package com.mb.ticketingsystem.dao;

import com.mb.ticketingsystem.entity.User;

public interface UserDao {
	User register(User user);
	
	User findUserByEmail(String email);
	
	User findUserById(Long id);
	User login(User user);
}
