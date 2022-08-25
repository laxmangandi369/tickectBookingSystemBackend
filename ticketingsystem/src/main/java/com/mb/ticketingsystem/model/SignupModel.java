package com.mb.ticketingsystem.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.lang.NonNull;

public class SignupModel {
	@NonNull
	private String firstName;
	@NonNull
	private String lastName;

	@Email
	@NotBlank
	private String email;
	@NonNull
	private String phoneNumber;
	@NonNull
	private char gender;

	@NotBlank
	private String password;

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public char getGender() {
		return gender;
	}

	public String getPassword() {
		return password;
	}
}
