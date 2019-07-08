package com.nagarro.flights.dao;

import java.util.List;

import com.nagarro.flights.models.Flights;

public interface FlightsDao {

	public List<Flights> getFlights(String dep, String arr, String date, String sort,String fclass);

}
