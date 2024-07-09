package com.service;

import com.dao.EmployeeDao;
import com.entity.Employee;

public class EmployeeService {
	EmployeeDao dao= new EmployeeDao();
	
	public void getEmployee() {
		dao.getEmployees();
	}
	
	public String addEmployee(Employee e) {
		
		dao.addEmployee(e);
		
		if(true) {
			return "Employee added Sucessfully";	
		} else
			return "Employee not added";
		
	}

	public void getCountOfEmployee() {
		dao.getCountOfEmployee();
		
	}

	public void getCountOfEmployeePerDepartment() {
		dao.getCountOfEmployeePerDepartment();
		
	}

	public void displayDepartments() {
		dao.displayDepartments();
	}

	public void getHighestPaidEmployee() {
		dao.getHighestPaidEmployee();		
	}

	public void getLowestPaidEmployee() {
		dao.getLowestPaidEmployee();
	}

	public void EmployeesSalaryMoreThanTwentyK() {
		dao.EmployeesSalaryMoreThanTwentyK();		
	}

	public void getAverageSalary() {
		dao.getAverageSalary();
	}

	public void getAverageSalaryTopFiveHighestPaid() {
		dao.getAverageSalaryTopFiveHighestPaid();
		
	}

	public void getSalaryBetween() {
		dao.getSalaryBetween();
	}

	public void getNameStartWithJ() {
		dao.getNameStartWithJ();		
	}

	public void getSalaryDesc() {
		dao.getSalaryDesc();		
	}

	public void getTotalSalary() {
		dao.getTotalSalary();		
	}

	public void getCountOfPuneEmployee() {
		dao.getCountOfPuneEmployee();		
	}

	public void getAverageSalaryDevDepartment() {
		dao.getAverageSalaryDevDepartment();		
	}

	public void getEmployeesOverAverageSalary() {
		dao.getEmployeesOverAverageSalary();		
	}

	public void getLowestPaidEmployeeTestDepartment() {
		dao.getLowestPaidEmployeeTestDepartment();
	}

	public void getTotalSalaryDevAndSupport() {
		dao.getTotalSalaryDevAndSupport();		
	}

	public void getEmployeesOverAverageSalaryDevDepartment() {
		dao.getEmployeesOverAverageSalaryDevDepartment();		
	}

	public void getTotalSalaryPuneLocation() {
		dao.getTotalSalaryPuneLocation();
	}

	
}
