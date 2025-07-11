package com.cognizant.spring_learn.service;


import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.spring_learn.model.Country;

@Service
public class CountryService {

    public Country getCountry(String code) throws Exception {
        @SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        @SuppressWarnings("unchecked")
		List<Country> countries = (List<Country>) context.getBean("countryList");

        return countries.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(() -> new Exception("Country not found with code: " + code));
    }
}
