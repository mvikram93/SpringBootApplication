package com.example.demo.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController

public class HomePageControllers {

	// inject via application.properties
		@Value("${app.welcome.message}")
		private String MESSAGE = "";

		@Value("${app.welcome.title}")
		private String TITLE = "";

		@RequestMapping(path= "/", method = RequestMethod.GET)
		public String index(Map<String, Object> model) {
			model.put("title", TITLE);
			model.put("message", MESSAGE);
			ModelAndView modelAndView = new ModelAndView();
		    modelAndView.setViewName("index");
		    //return modelAndView;
			return "index.html";
		}

		// test 5xx errors
		@RequestMapping("/5xx")
		public String ServiceUnavailable() {
			throw new RuntimeException("ABC");
		}
	/*@RequestMapping(path="/index", method = RequestMethod.GET)
	public String index() {
	return "HElloa!";
}*/
	
	 /*  @RequestMapping(value = "/hello", method = RequestMethod.GET)  
	    public String hello(){  
	        return"Hello!";  
	    }*/  
	}
