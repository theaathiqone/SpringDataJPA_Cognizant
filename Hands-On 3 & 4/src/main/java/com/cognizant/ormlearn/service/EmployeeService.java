package com.cognizant.ormlearn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.repository.EmployeeRepository;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class EmployeeService {
	
	private Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Transactional
	public Employee get(int id) {
		LOGGER.info("Start");
		return employeeRepository.findById(id).get();
	}
	
	@Transactional
	public void save(Employee employee) {
		LOGGER.info("Start");
		employeeRepository.save(employee);
		LOGGER.info("End");
	}
	
	@Transactional
	public List<Employee> getAllPermanentEmployees(){
		return employeeRepository.getAllPermanentEmployees();
	}
	
	@Transactional
	public double getAverageSalary(int departmentId) {
		return employeeRepository.getAverageSalary(departmentId);
	}
	
	@Transactional
	public List<Employee> getAllEmployeesNative(){
		return employeeRepository.getAllEmployeesNative();
	}
}
