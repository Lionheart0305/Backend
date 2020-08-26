package com.lti.airfuselage.service;

import com.lti.airfuselage.model.SystemAdmin;
import com.lti.airfuselage.model.User;

public interface UserService {

	void register(User user);

	User login(String email, String password);

	SystemAdmin adminlogin(String email, String password);
}
