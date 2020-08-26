package com.lti.airfuselage.controller;

import java.time.LocalDate;

import javax.persistence.Column;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.airfuselage.controller.UserControllerImpl.Status.StatusType;
import com.lti.airfuselage.dto.AdminLoginDto;
import com.lti.airfuselage.dto.LoginDto;
import com.lti.airfuselage.exception.CustomerServiceException;
import com.lti.airfuselage.model.SystemAdmin;
import com.lti.airfuselage.model.User;
import com.lti.airfuselage.service.UserService;

@RestController
@CrossOrigin
public class UserControllerImpl {

	@Autowired
	private UserService userService;

	// @RequestMapping(path="/register", method = RequestMethod.POST)
	@PostMapping("/register")
	public Status register(@RequestBody User user) {
		// Status status= new Status();
		try {
			userService.register(user);
			Status status = new Status();
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Registration Successfull");
			return status;
			/*
			 * status.setStatus(StatusType.SUCCESS);
			 * status.setMessage("Registration Successful");
			 */
		} catch (CustomerServiceException e) {
			/*
			 * status.setStatus(StatusType.FAILURE); status.setMessage(e.getMessage());
			 */
			Status status = new Status();
			status.setStatus(StatusType.FAILURE);
			status.setMessage("Registration Failure");
			return status;
		}
		// return status;
	}
	
	@PostMapping("/login")
	public LoginStatus login(@RequestBody LoginDto loginDto) {
		try {
			User u=userService.login(loginDto.getEmail(), loginDto.getPassword());
			LoginStatus loginStatus=new LoginStatus();
			loginStatus.setStatus(StatusType.SUCCESS);
			loginStatus.setMessage("Login successful");
			loginStatus.setUserId(u.getUserId());
			loginStatus.setFirstName(u.getFirstName());
			loginStatus.setLastName(u.getLastName());
			loginStatus.setDateOfBirth(u.getDateOfBirth());
			loginStatus.setMobileNumber(u.getMobileNumber());
			return loginStatus;
		}
		catch (CustomerServiceException e) {
			LoginStatus loginStatus=new LoginStatus();
			loginStatus.setStatus(StatusType.FAILURE);
			loginStatus.setMessage(e.getMessage());
			return loginStatus;
		}

	}

	public static class LoginStatus extends Status {

		private int userId;
		private String firstName;
		private String lastName;
		private LocalDate dateOfBirth;
		private String mobileNumber;

		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public LocalDate getDateOfBirth() {
			return dateOfBirth;
		}

		public void setDateOfBirth(LocalDate dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}

		public String getMobileNumber() {
			return mobileNumber;
		}

		public void setMobileNumber(String mobileNumber) {
			this.mobileNumber = mobileNumber;
		}

	}
	
	@PostMapping("/adminlogin")
	public AdminLoginStatus Adminlogin(@RequestBody AdminLoginDto adminloginDto) {
		try {
			SystemAdmin u=userService.adminlogin(adminloginDto.getEmail(), adminloginDto.getPassword());
			AdminLoginStatus adminloginStatus=new AdminLoginStatus();
			adminloginStatus.setStatus(StatusType.SUCCESS);
			adminloginStatus.setMessage("Login successful");
			adminloginStatus.setUserId(u.getId());
			adminloginStatus.setFirstName(u.getFirstName());
			adminloginStatus.setLastName(u.getLastName());
			adminloginStatus.setDateOfBirth(u.getDateOfBirth());
			adminloginStatus.setMobileNumber(u.getMobileNumber());
			return adminloginStatus;
		}
		catch (CustomerServiceException e) {
			AdminLoginStatus adminloginStatus=new AdminLoginStatus();
			adminloginStatus.setStatus(StatusType.FAILURE);
			adminloginStatus.setMessage(e.getMessage());
			return adminloginStatus;
		}

	}

	public static class AdminLoginStatus extends Status {

		private int id;
		private String firstName;
		private String lastName;
		private LocalDate dateOfBirth;
		private String mobileNumber;

		public int getId() {
			return id;
		}

		public void setUserId(int id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public LocalDate getDateOfBirth() {
			return dateOfBirth;
		}

		public void setDateOfBirth(LocalDate dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}

		public String getMobileNumber() {
			return mobileNumber;
		}

		public void setMobileNumber(String mobileNumber) {
			this.mobileNumber = mobileNumber;
		}

	}

	public static class Status {
		private StatusType status;
		private String message;

		public static enum StatusType {
			SUCCESS, FAILURE;
		}

		public StatusType getStatus() {
			return status;
		}

		public void setStatus(StatusType status) {
			this.status = status;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

	}

}
