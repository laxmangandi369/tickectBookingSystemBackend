package com.mb.ticketingsystem.service;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb.ticketingsystem.dao.UserDao;
import com.mb.ticketingsystem.entity.User;
import com.mb.ticketingsystem.exception.CustomException;
import com.mb.ticketingsystem.exception.ErrorCode;
import com.mb.ticketingsystem.model.LoginModel;
import com.mb.ticketingsystem.model.SignupModel;
import com.mb.ticketingsystem.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {


	@Autowired
	private ModelMapper mapper;

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserRepository userRepository;

	@Override
	public User registerUser(SignupModel userSignup) {
		if (userDao.findUserByEmail(userSignup.getEmail()) != null) {
			throw new CustomException("User already registered with " + userSignup.getEmail() + " address.",
					ErrorCode.RESOURCE_ALREADY_EXISTS);
		} else {

			User user = new User();


			user = mapper.map(userSignup, User.class);

//			user.setPassWord(passwordEncoder.encode(user.getPassWord()));

			userDao.register(user);

			return user;
		}
	}

	@Override
	public User login(@Valid LoginModel user) {
		
			User isRegistered = userDao.findUserByEmail(user.getEmail());
			
			if(isRegistered!=null)
			{
				return isRegistered;
			}
			else {
				throw new CustomException("user not registered",ErrorCode.BAD_REQUEST);
			}

	}

	@Override
	public List<User> getAllUsers() {
		List<User> allUsers =null;
		allUsers= userRepository.findAll();
		if(allUsers!=null)
		{
			return allUsers;
		}
		else {
			throw new CustomException("no user found", ErrorCode.NOT_FOUND);

		}
	}

}
