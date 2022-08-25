package com.mb.ticketingsystem.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb.ticketingsystem.entity.User;
import com.mb.ticketingsystem.exception.CustomException;
import com.mb.ticketingsystem.exception.ErrorCode;
import com.mb.ticketingsystem.repository.UserRepository;

@Service
public class UserDaoImpl implements UserDao {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User register(User user) {
		try {
			return userRepository.save(user);
		} catch (Exception e) {
			throw new CustomException("error while saving " + user.getFirstName(), ErrorCode.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public User findUserByEmail(String email) {
		User user = null;
		user = userRepository.findByEmail(email);
		if (user != null) {
			return user;
		} else {
//			throw new CustomException("user not registerd",ErrorCode.INTERNAL_SERVER_ERROR);
			return null;
		}
	}

	@Override
	public User findUserById(Long id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isEmpty()) {
			throw new CustomException(id + " not registered in the database", ErrorCode.NOT_FOUND);
		} else {
			return user.get();
		}
	}

	@Override
	public User login(User user) {
		User isLogedin = null;
		isLogedin = userRepository.findByEmail(user.getEmail());
		if (isLogedin == null) {
			throw new CustomException("user not registered", ErrorCode.INTERNAL_SERVER_ERROR);
		} else {
			return isLogedin;
		}
	}

}
