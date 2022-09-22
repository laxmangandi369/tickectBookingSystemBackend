package com.mb.ticketingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mb.ticketingsystem.model.LoginModel;
import com.mb.ticketingsystem.model.SignupModel;
import com.mb.ticketingsystem.model.SuccessResponse;
import com.mb.ticketingsystem.service.UserService;
import static com.mb.ticketingsystem.constants.UrlMapping.USER_URL;

import javax.validation.Valid;


@RestController
@RequestMapping(USER_URL)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@GetMapping
	public ResponseEntity<SuccessResponse> getAllUsers()
	{
		SuccessResponse response= new SuccessResponse();
		response.setData(userService.getAllUsers());
		response.setMessage("All Registered Users");
		response.setSuccessCode(HttpStatus.OK.value());
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@PostMapping("/register/user")
	public ResponseEntity<SuccessResponse> registerUser(@RequestBody @Valid SignupModel signup)
	{
		SuccessResponse response= new SuccessResponse();
		response.setData(userService.registerUser(signup));
		response.setMessage("successfully registered");
		response.setSuccessCode(HttpStatus.OK.value());
		
		return new ResponseEntity<>(response,HttpStatus.OK);		
	}
	
	@PostMapping("/register/admin")
	public ResponseEntity<SuccessResponse> registerAdmin(@RequestBody @Valid SignupModel signup)
	{
		SuccessResponse response= new SuccessResponse();
		response.setData(userService.registerAdmin(signup));
		response.setMessage("successfully registered");
		response.setSuccessCode(HttpStatus.OK.value());
		
		return new ResponseEntity<>(response,HttpStatus.OK);		
	}
	
	@PostMapping("/login")
	public ResponseEntity<SuccessResponse> loginUser(@RequestBody @Valid  LoginModel login)
	{
		final Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword()));
		
		SuccessResponse response= new SuccessResponse();
		response.setData(userService.login(authentication));
		response.setMessage("successfully loggedin");
		response.setSuccessCode(HttpStatus.OK.value());
		
		return new ResponseEntity<>(response,HttpStatus.OK);		

	}
}
