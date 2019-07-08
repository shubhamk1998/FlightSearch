package com.nagarro.flights.services;

import java.util.List;

import com.nagarro.flights.models.Flights;

public interface FlightService {
	public List<Flights> getFlights(String dep, String arr, String date, String sort,String fclass);

}
