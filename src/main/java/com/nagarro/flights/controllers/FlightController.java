package com.nagarro.flights.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.flights.models.Flights;
import com.nagarro.flights.services.FlightImplementation;
import com.nagarro.flights.services.FlightService;
import com.nagarro.flights.services.LoginService;

@Controller
public class FlightController {

	
	private FlightService flightService;
	
	@Autowired(required=true)
	@Qualifier(value="flightService")
	public void setFlightService(FlightService fs){
		this.flightService= fs;
	}
	
	@RequestMapping(value="/Flights",method=RequestMethod.GET)
	public String redirect(HttpServletRequest request, ModelAndView m) {
		System.out.println(request.getAttribute("authorized"));
		return "index";
	}

	@RequestMapping(value="/search",method=RequestMethod.POST)
	public String search(@RequestParam String arrloc, @RequestParam String deploc, @RequestParam String sort,
			@RequestParam("date") String date, HttpServletRequest request,@RequestParam String fclass, Model m) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		String newdate = (sdf.format(sdf2.parse(date)));
		List<Flights> allflights = this.flightService.getFlights(deploc, arrloc, newdate, sort,fclass);
		request.getSession().setAttribute("flights", allflights);

		// m.addAttribute("flights",flights.getFlights());
		return "index";

	}

}
