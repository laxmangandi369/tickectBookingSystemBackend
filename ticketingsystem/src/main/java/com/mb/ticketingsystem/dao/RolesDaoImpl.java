package com.mb.ticketingsystem.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mb.ticketingsystem.entity.Role;
import com.mb.ticketingsystem.exception.CustomException;
import com.mb.ticketingsystem.exception.ErrorCode;
import com.mb.ticketingsystem.repository.RoleRepository;

public class RolesDaoImpl implements RolesDao {

	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public List<Role> allRoles() {
		List<Role> allRoles = roleRepository.findAll();
		if(allRoles.isEmpty())
		{
			throw new CustomException("no roles found", ErrorCode.INTERNAL_SERVER_ERROR);
		}
		else {
			return allRoles;
		}
	}

}
