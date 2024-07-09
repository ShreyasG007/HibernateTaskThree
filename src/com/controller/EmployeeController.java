package com.controller;

import com.entity.Employee;
import com.service.EmployeeService;

public class EmployeeController {
	EmployeeService service = new EmployeeService();

	public void getEmployee() {
		service.getEmployee();
	}

	public String addEmployee(Employee e) {
		return service.addEmployee(e);
	}

	public void getCountOfEmployee() {
		service.getCountOfEmployee();

	}

	public void getCountOfEmployeePerDepartment() {
		service.getCountOfEmployeePerDepartment();

	}

	public void displayDepartments() {
		service.displayDepartments();
	}

	public void getHighestPaidEmployee() {
		service.getHighestPaidEmployee();
	}

	public void getLowestPaidEmployee() {
		service.getLowestPaidEmployee();

	}

	public void getEmployeesSalaryMoreThanTwentyK() {
		service.EmployeesSalaryMoreThanTwentyK();
	}

	public void getAverageSalary() {
		service.getAverageSalary();
	}

	public void getAverageSalaryTopFiveHighestPaid() {
		service.getAverageSalaryTopFiveHighestPaid();
	}

	public void getSalaryBetween() {
		service.getSalaryBetween();
	}

	public void getNameStartWithJ() {
		service.getNameStartWithJ();
	}

	public void getSalaryDesc() {
		service.getSalaryDesc();
	}

	public void getTotalSalary() {
		service.getTotalSalary();		
	}

	public void getCountOfPuneEmployee() {
		service.getCountOfPuneEmployee();
		
	}

	public void getAverageSalaryDevDepartment() {
		service.getAverageSalaryDevDepartment();
	}

	public void getEmployeesOverAverageSalary() {
		service.getEmployeesOverAverageSalary();
	}

	public void getLowestPaidEmployeeTestDepartment() {
		service.getLowestPaidEmployeeTestDepartment();
	}

	public void getTotalSalaryDevAndSupport() {
		service.getTotalSalaryDevAndSupport();
	}

	public void getEmployeesOverAverageSalaryDevDepartment() {
		service.getEmployeesOverAverageSalaryDevDepartment();		
	}

	public void getTotalSalaryPuneLocation() {
		service.getTotalSalaryPuneLocation();
	}
}
