package com.mb.ticketingsystem.service;

import java.util.List;
import java.util.Map;

import org.springframework.security.core.Authentication;

import com.mb.ticketingsystem.entity.User;
import com.mb.ticketingsystem.model.LoginModel;
import com.mb.ticketingsystem.model.SignupModel;

public interface UserService {

	Map<String , Object> registerUser(SignupModel userSignup);
//	User registerUser(SignupModel userSignup);

	public Map<String,Object> registerAdmin(SignupModel adminSignup);
	
	List<User> getAllUsers();
//	Map<String , Object> login(LoginModel user);
	String login(Authentication authentication);

}
