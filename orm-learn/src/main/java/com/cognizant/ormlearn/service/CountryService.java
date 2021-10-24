package com.cognizant.ormlearn.service;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.exception.CountryNotFoundException;
import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;


@Service
public class CountryService {
	
	@Autowired
	CountryRepository repository;
	
	@Transactional
	public List<Country> getAllCountries(){
		return repository.findAll();
	}
	
	//HandsOn 1-6
	@Transactional
	public Country findCountrybyCode(String countryCode) throws CountryNotFoundException{
		Optional<Country> result = repository.findById(countryCode);
		
		if(!result.isPresent())
			throw new CountryNotFoundException("Country not found");
		else {
			Country country = result.get();
			return country;
		}
		
	}
	
	//HandsOn 1-7
	public void addCountry(Country country) {
		repository.save(country);
	}

}
