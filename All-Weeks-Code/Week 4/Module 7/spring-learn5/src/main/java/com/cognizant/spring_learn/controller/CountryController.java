package com.cognizant.spring_learn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.spring_learn.model.Country;
import com.cognizant.spring_learn.service.CountryService;

@RestController
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);
    
    @Autowired
    private CountryService countryService;

    @GetMapping("/hello")
    public String sayHello() {
        LOGGER.info("START");
        String response = "Hello World!!";
        LOGGER.info("END");
        return response;
    }
    
    @GetMapping("/country")
	public Country getCountryIndia() {
		LOGGER.info("START - getCountryIndia()");
		
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = (Country) context.getBean("in");
		
		LOGGER.info("END - getCountryIndia()");
		return country;
	}
    
    

    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) throws Exception {
        return countryService.getCountry(code);
    }
}
