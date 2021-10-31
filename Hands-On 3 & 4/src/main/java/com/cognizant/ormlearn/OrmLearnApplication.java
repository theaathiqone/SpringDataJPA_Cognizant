package com.cognizant.ormlearn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;


@SpringBootApplication
public class OrmLearnApplication {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	
	public static EmployeeService employeeService;
	public static DepartmentService departmentService;
	private static SkillService skillService;
	
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		employeeService = context.getBean(EmployeeService.class);
		departmentService = context.getBean(DepartmentService.class);
		skillService = context.getBean(SkillService.class);
		
	}
	
	private static void testGetEmployee() {
		LOGGER.info("Start");
		Employee employee = employeeService.get(1);
		LOGGER.debug("Employee:{}", employee);
		LOGGER.debug("Department:{}", employee.getDepartment());
		LOGGER.info("End");
	}
	
	private static void testGetAllPermanentEmployees() {
		LOGGER.info("Start");
		List<Employee> employees = employeeService.getAllPermanentEmployees();
		LOGGER.debug("Permanent Employees:{}", employees);
		
		employees.forEach(e -> LOGGER.debug("Skills:{}", e.getSkillList()));
		LOGGER.info("End");
	}
	
	private static void testGetAverageSalary() {
		LOGGER.info("Start");
		double averageSalary = employeeService.getAverageSalary(1);
		LOGGER.debug("averageSalary:{}", averageSalary);
		LOGGER.info("End");
	}
	
	
	private static void testGetAllEmployeesNative() {
		LOGGER.info("Start");
		List<Employee> employeeList = employeeService.getAllEmployeesNative();
		LOGGER.debug("Employees:{}", employeeList);
		LOGGER.info("End");
	}
}