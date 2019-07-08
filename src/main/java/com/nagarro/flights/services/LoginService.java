package com.nagarro.flights.services;

import com.nagarro.flights.models.User;

public interface LoginService {
	public User getUserDetails(String username);
    public Boolean userAuthentication(String username, String password);
}
