package com.mb.ticketingsystem.service;

import java.util.List;

import com.mb.ticketingsystem.entity.User;
import com.mb.ticketingsystem.model.LoginModel;
import com.mb.ticketingsystem.model.SignupModel;

public interface UserService {

	User registerUser(SignupModel userSignup);
	List<User> getAllUsers();
	User login(LoginModel user);
}
