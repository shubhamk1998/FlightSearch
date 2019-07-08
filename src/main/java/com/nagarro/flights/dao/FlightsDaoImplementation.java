package com.nagarro.flights.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.nagarro.flights.models.Flights;


public class FlightsDaoImplementation implements FlightsDao {
	
    private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	
	public List<Flights> getFlights(String dep, String arr, String date, String sort,String fclass) {
        Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(Flights.class);
		cr.add(Restrictions.eq("depLoc", dep.toUpperCase()));
		cr.add(Restrictions.eq("arrLoc", arr.toUpperCase()));
		cr.add(Restrictions.eq("avail", "Y"));
		if(!("".equals(fclass))) {
			cr.add(Restrictions.like("fclass",fclass,MatchMode.ANYWHERE));			
		}
		if (sort.equals("1")) {
			cr.addOrder(Order.asc("fare"));
		}
		if (sort.equals("2")) {
			cr.addOrder(Order.asc("fare"));
			cr.addOrder(Order.asc("flightDur"));
		}
		@SuppressWarnings("unchecked")
		List<Flights> results = cr.list();
		final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		return results.stream().filter(p -> {
			try {
				return (sdf.parse(p.getvalidtill()).compareTo(sdf.parse(date)) >= 0);
	
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return false;
		}).collect(Collectors.toList());

	}

	
}
