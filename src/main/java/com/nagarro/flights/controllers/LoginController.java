package com.nagarro.flights.controllers;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nagarro.flights.models.User;
import com.nagarro.flights.services.LoginService;

@Controller
public class LoginController {
	
	private LoginService loginService;
	
	@Autowired(required=true)
	@Qualifier(value="loginService")
	public void setLoginService(LoginService ls){
		this.loginService= ls;
	}
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String redirect() {
		return "login";
	}

	@RequestMapping(value="/Login",method=RequestMethod.POST)
	public String login(RedirectAttributes redirectAttributes, HttpServletRequest request,@RequestParam String username, @RequestParam String password, ModelAndView m) {
		if (this.loginService.userAuthentication(username, password)) {
			User user = this.loginService.getUserDetails(username);
			request.setAttribute("authorized", true);
			redirectAttributes.addAttribute("authorized", true);
			request.setAttribute("user", user);
			return "redirect:/Flights";
		} else {
			request.setAttribute("authorized", false);
			return "/";
		}
	}
}
