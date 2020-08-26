package com.lti.airfuselage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lti.airfuselage.dao.UserRepository;
import com.lti.airfuselage.exception.CustomerServiceException;
import com.lti.airfuselage.model.SystemAdmin;
import com.lti.airfuselage.model.User;

//@Component
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public void register(User user) {
		if (!userRepo.isUserPresent(user.getEmail()))
			userRepo.add(user);
		else
			throw new CustomerServiceException("User Already Registered");

	}

	@Override
	public User login(String email, String password) {
		try {
			int userId = userRepo.login(email, password);
			User u = userRepo.findById(userId);
			return u;
		} catch (EmptyResultDataAccessException e) {
			throw new CustomerServiceException("Incorrect username/password");
		}
	}
	
	@Override
	public SystemAdmin adminlogin(String email, String password) {
		try {
			int userId = userRepo.adminlogin(email, password);
			SystemAdmin u = userRepo.findByadminId(userId);
			return u;
		} catch (EmptyResultDataAccessException e) {
			throw new CustomerServiceException("Incorrect username/password");
		}
	}

}
