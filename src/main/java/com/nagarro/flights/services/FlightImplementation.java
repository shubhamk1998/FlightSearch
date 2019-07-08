package com.nagarro.flights.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.nagarro.flights.dao.FlightsDao;
import com.nagarro.flights.models.Flights;

public class FlightImplementation implements FlightService {

	private FlightsDao FlightsDao;

	public void setFlightsDao(FlightsDao FlightsDao) {
		this.FlightsDao = FlightsDao;
	}


    
    @Override
    @Transactional
	public List<Flights> getFlights(String dep, String arr, String date, String sort,String fclass) {
			return this.FlightsDao.getFlights(dep, arr, date, sort, fclass);
	}

}
