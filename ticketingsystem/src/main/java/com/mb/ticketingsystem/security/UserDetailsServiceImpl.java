package com.mb.ticketingsystem.security;

import java.util.List;
import java.util.stream.Collectors;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mb.ticketingsystem.dao.UserDao;
import com.mb.ticketingsystem.entity.User;
import com.mb.ticketingsystem.exception.CustomException;
import com.mb.ticketingsystem.exception.ErrorCode;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User myUser = userDao.findUserByEmail(username);
		List<SimpleGrantedAuthority> grantedAuthorities = myUser.getRole().stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());

		if (myUser != null) {
			return new org.springframework.security.core.userdetails.User(
					myUser.getEmail(), myUser.getPassword(), grantedAuthorities);

			
		} else {
			throw new CustomException("User " + username + " does not exist in database",
					ErrorCode.AUTHENTICATION_FAILED);
		}
	}

}
