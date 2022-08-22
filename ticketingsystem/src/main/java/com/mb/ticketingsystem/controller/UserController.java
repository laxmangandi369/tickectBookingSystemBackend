package com.mb.ticketingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


@RestController
@RequestMapping(USER_URL)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<SuccessResponse> getAllUsers()
	{
		SuccessResponse response= new SuccessResponse();
		response.setData(userService.getAllUsers());
		response.setMessage("All Registered Users");
		response.setSuccessCode(HttpStatus.OK.value());
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@PostMapping("register")
	public ResponseEntity<SuccessResponse> registerUser(@RequestBody SignupModel signup)
	{
		SuccessResponse response= new SuccessResponse();
		response.setData(userService.registerUser(signup));
		response.setMessage("successfully registered");
		response.setSuccessCode(HttpStatus.OK.value());
		
		return new ResponseEntity<>(response,HttpStatus.OK);		
	}
	@PostMapping("login")
	public ResponseEntity<SuccessResponse> loginUser(@RequestBody LoginModel login)
	{
		SuccessResponse response= new SuccessResponse();
		response.setData(userService.login(login));
		response.setMessage("successfully loggedin");
		response.setSuccessCode(HttpStatus.OK.value());
		
		return new ResponseEntity<>(response,HttpStatus.OK);		

	}
}
