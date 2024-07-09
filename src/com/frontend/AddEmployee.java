package com.frontend;

import com.controller.EmployeeController;
import com.entity.Employee;

public class AddEmployee {

	public static void main(String[] args) {
		
		Employee e1 = new Employee(1,"Anup",10000.00,"Dev","Pune");
		Employee e2 = new Employee(2,"Rani",26000.00,"Test","Nashik");
		Employee e3 = new Employee(3,"Jay",18000.00,"Dev","Nagpur");
		Employee e4 = new Employee(4,"Vishal",22000.00,"Support","Pune");
		Employee e5 = new Employee(5,"Shina",35000.00,"Test","Nagpur");
		Employee e6 = new Employee(6,"Rony",11000.00,"Support","Nagpur");
		Employee e7 = new Employee(7,"Pooja",38000.00,"Dev","Nashik");
		
		EmployeeController controller = new EmployeeController();
		controller.addEmployee(e1);
		controller.addEmployee(e2);
		controller.addEmployee(e3);
		controller.addEmployee(e4);
		controller.addEmployee(e5);
		controller.addEmployee(e6);
		controller.addEmployee(e7);
	

	}

}
