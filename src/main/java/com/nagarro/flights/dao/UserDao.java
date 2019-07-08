package com.nagarro.flights.dao;

import com.nagarro.flights.models.User;

public interface UserDao {
    public User getUserDetails(String username);
    public Boolean userAuthentication(String username, String password);
}
