package com.mb.ticketingsystem.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mb.ticketingsystem.dao.UserDao;
import com.mb.ticketingsystem.entity.Role;
import com.mb.ticketingsystem.entity.User;
import com.mb.ticketingsystem.exception.CustomException;
import com.mb.ticketingsystem.exception.ErrorCode;
import com.mb.ticketingsystem.model.LoginModel;
import com.mb.ticketingsystem.model.SignupModel;
import com.mb.ticketingsystem.repository.RoleRepository;
import com.mb.ticketingsystem.repository.UserRepository;
import com.mb.ticketingsystem.security.JwtTokenUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private UserDao userDao;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public Map<String,Object> registerUser(SignupModel userSignup) {
		
		if (userDao.findUserByEmail(userSignup.getEmail()) != null) {
			throw new CustomException("User already registered with " + userSignup.getEmail() + " address.",
					ErrorCode.RESOURCE_ALREADY_EXISTS);
		} else {
			
			Set<Role> roles = new HashSet<>();
			
			roles.add(roleRepository.findByName("USER"));
			
			User user;

			user = mapper.map(userSignup, User.class);
			
			user.setPassword(passwordEncoder.encode(userSignup.getPassword()));
			user.setRole(roles);
			userDao.register(user);
			return Collections.singletonMap("username", user.getEmail());
		}
	}
	@Override
	public Map<String,Object> registerAdmin(SignupModel adminSignup)
	{
		if (userDao.findUserByEmail(adminSignup.getEmail()) != null) {
			throw new CustomException("User already registered with " + adminSignup.getEmail() + " address.",
					ErrorCode.RESOURCE_ALREADY_EXISTS);
		} else {
			
			Set<Role> roles = new HashSet<>();
			
			roles.add(roleRepository.findByName("USER"));
			roles.add(roleRepository.findByName("ADMIN"));
			
			User user;

			user = mapper.map(adminSignup, User.class);
			
			user.setPassword(passwordEncoder.encode(adminSignup.getPassword()));
			user.setRole(roles);
			userDao.register(user);
			return Collections.singletonMap("username", user.getEmail());
		}
	}

	@Override
	public String login(Authentication authentication) {

//		User isRegistered = userDao.findUserByEmail(user.getEmail());
//
//		if (isRegistered != null && Objects.equals(isRegistered.getPassword(), user.getPassword())) {
//			return isRegistered;
//		} else {
//			throw new CustomException("user not registered", ErrorCode.BAD_REQUEST);
//		}
		
		return jwtTokenUtil.generateToken(authentication);
		
	}

	@Override
	public List<User> getAllUsers() {
		List<User> allUsers = null;
		allUsers = userRepository.findAll();
		if (allUsers != null) {
			return allUsers;
		} else {
			throw new CustomException("no user found", ErrorCode.NOT_FOUND);

		}
	}

//	@Override
//	public User registerUser(SignupModel userSignup) {
//		if (userDao.findUserByEmail(userSignup.getEmail()) != null) {
//			throw new CustomException("User already registered with " + userSignup.getEmail() + " address.",
//					ErrorCode.RESOURCE_ALREADY_EXISTS);
//		} else {
//
//			User user;
//
//			user = mapper.map(userSignup, User.class);
//			
//			userDao.register(user);
//			
//			return user;
//		}
//	}

}
