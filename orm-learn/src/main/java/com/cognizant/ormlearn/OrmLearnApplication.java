package com.cognizant.ormlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.exception.CountryNotFoundException;
import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class OrmLearnApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	private static CountryService countryService;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		countryService = context.getBean(CountryService.class);
		
		testGetAllCountries();
		LOGGER.info("Inside main");
	}
	
	//HandsOn Part 1
	private static void testGetAllCountries() {
		LOGGER.info("Start");
		List<Country> countries = countryService.getAllCountries();
		LOGGER.debug("countries={}", countries);
		LOGGER.info("End");
	}
	
	private static void getAllCountriesTest() throws CountryNotFoundException{
		LOGGER.info("Start"); 
		Country country = countryService.findCountrybyCode("IN"); 
		LOGGER.debug("Country:{}", country); 
		LOGGER.info("End"); 
	}
	
	
	private static void testAddCountry() throws CountryNotFoundException {
		LOGGER.info("Start");
		Country newCountry = new Country("RC", "Random Country");
		countryService.addCountry(newCountry);
		
		Country country = countryService.findCountrybyCode("RC");
		
		LOGGER.debug("Country:{}", country); 
		LOGGER.info("End");
				
	}

}
