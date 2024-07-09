package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.config.HibernateConfiguration;
import com.entity.Employee;

public class EmployeeDao {
	public void getEmployees() {
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction transaction = openSession.beginTransaction();

		Criteria criteria = openSession.createCriteria(Employee.class);
		List<Employee> list = criteria.list();
		for (Employee employee : list) {
			System.out.println(employee);
		}
		transaction.commit();
	}

	public boolean addEmployee(Employee e) {
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction transaction = openSession.beginTransaction();

		openSession.save(e);
		transaction.commit();
		return true;
	}

	public void getCountOfEmployee() {
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction transaction = openSession.beginTransaction();
		
		Criteria criteria = openSession.createCriteria(Employee.class);
		criteria.setProjection(Projections.count("id"));
		List list = criteria.list();
		System.out.println("TotalCount : "+list);
		
		transaction.commit();
	
	}

	public void getCountOfEmployeePerDepartment() {
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction transaction = openSession.beginTransaction();
		
		Criteria criteria = openSession.createCriteria(Employee.class);
		criteria.setProjection(Projections.projectionList()
		    .add(Projections.groupProperty("department"))
		    .add(Projections.rowCount(), "count"));

		List<Object[]> results = criteria.list();

		for (Object[] result : results) {
		    String department = (String) result[0];
		    Long count = (Long) result[1];
		    System.out.println("Department: " + department + ", Count: " + count);
		}
		
		transaction.commit();
		
	}

	public void displayDepartments() {
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction transaction = openSession.beginTransaction();
		
		Criteria criteria = openSession.createCriteria(Employee.class);
		criteria.setProjection(Projections.groupProperty("department"));
		List<String> list = criteria.list();
		
		for (String string : list) {
			System.out.println(string);
		}
	}

	public void getHighestPaidEmployee() {
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction transaction = openSession.beginTransaction();
		
		Criteria criteria = openSession.createCriteria(Employee.class);
		criteria.setProjection(Projections.max("salary"));
		double maxSalary = (double) criteria.uniqueResult();
		
		Criteria maxSalCriteria = openSession.createCriteria(Employee.class);
		maxSalCriteria.add(Restrictions.eq("salary", maxSalary));
		List<Employee> list = maxSalCriteria.list();
		for (Employee employee : list) {
			System.out.println("Highest Paid Employee : "+employee);
		}
		
				
	}

	public void getLowestPaidEmployee() {
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction transaction = openSession.beginTransaction();
		
		Criteria criteria = openSession.createCriteria(Employee.class);
		criteria.setProjection(Projections.min("salary"));
		double minSalary = (double) criteria.uniqueResult();
		
		Criteria minSalCriteria = openSession.createCriteria(Employee.class);
		minSalCriteria.add(Restrictions.eq("salary", minSalary));
		List<Employee> list = minSalCriteria.list();
		for (Employee employee : list) {
			System.out.println("Lowest Paid Employee : "+employee);
		}
		
	}

	public void EmployeesSalaryMoreThanTwentyK() {
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction transaction = openSession.beginTransaction();
		int count = 0;
		Criteria criteria = openSession.createCriteria(Employee.class);
		criteria.add(Restrictions.gt("salary", 20000.00));
		List<Employee> list = criteria.list();
		
		for (Employee employee : list) {
			System.out.println(employee);
			count++;
		}
		System.out.println("Total Employees salary greater than 20000 : "+count);
	}

	public void getAverageSalary() {
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction transaction = openSession.beginTransaction();
		
		Criteria criteria = openSession.createCriteria(Employee.class);
		criteria.setProjection(Projections.avg("salary"));
		List list = criteria.list();
		System.out.println("Average Salary : "+list);
		
		transaction.commit();// TODO Auto-generated method stub
		
	}

	public void getAverageSalaryTopFiveHighestPaid() {
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction transaction = openSession.beginTransaction();
		
		Criteria criteria = openSession.createCriteria(Employee.class);
		criteria.addOrder(Order.desc("salary"));
		criteria.setMaxResults(5);
		List<Employee> list = criteria.list();
		for (Employee employee : list) {
			System.out.println(employee);
		}
		
		transaction.commit();
		
	}

	public void getSalaryBetween() {
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction transaction = openSession.beginTransaction();
		
		Criteria criteria = openSession.createCriteria(Employee.class);
		criteria.add(Restrictions.between("salary", 15000.00, 25000.00));
		List<Employee> list = criteria.list();
		
		for (Employee employee : list) {
			System.out.println(employee);
		}
		
		transaction.commit();
				
	}

	public void getNameStartWithJ() {
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction transaction = openSession.beginTransaction();
		
		Criteria criteria = openSession.createCriteria(Employee.class);
		criteria.add(Restrictions.like("name", "J%"));
		List<Employee> list = criteria.list();
		
		for (Employee employee : list) {
			System.out.println(employee);
		}
		
		transaction.commit();
						
	}

	public void getSalaryDesc() {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction transaction = openSession.beginTransaction();
		
		Criteria criteria = openSession.createCriteria(Employee.class);
		criteria.addOrder(Order.desc("salary"));
		List<Employee> list = criteria.list();
		for (Employee employee : list) {
			System.out.println(employee);
		}
		
		transaction.commit();
	}

	public void getTotalSalary() {
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction transaction = openSession.beginTransaction();
		
		Criteria criteria = openSession.createCriteria(Employee.class);
		criteria.setProjection(Projections.sum("salary"));
		List list = criteria.list();
		
		System.out.println("Total Salary Expenditure : "+list);
		
		transaction.commit();
		
	}

	public void getCountOfPuneEmployee() {
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction transaction = openSession.beginTransaction();
		
		Criteria criteria = openSession.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("location", "pune"));
		criteria.setProjection(Projections.count("id"));
		List list = criteria.list();
		
		
		System.out.println("Count of Pune employees : "+list);
		
		transaction.commit();
	}

	public void getAverageSalaryDevDepartment() {
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction transaction = openSession.beginTransaction();
		
		Criteria criteria = openSession.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("department", "dev"));
		criteria.setProjection(Projections.sum("salary"));
		List list = criteria.list();
		
		
		System.out.println("Total Expenditure Dev Department : "+list);
		
		transaction.commit();
		
	}

	public void getEmployeesOverAverageSalary() {
		
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction transaction = openSession.beginTransaction();
		
		Criteria criteria = openSession.createCriteria(Employee.class);
		criteria.setProjection(Projections.avg("salary"));
		double avgSal = (double) criteria.uniqueResult();
		
		
		Criteria criteria2 = openSession.createCriteria(Employee.class);
		criteria2.add(Restrictions.gt("salary", avgSal));
		List<Employee> list = criteria2.list();
		
		for (Employee employee : list) {
			System.out.println(employee);
		}
		
		transaction.commit();
	}

	public void getLowestPaidEmployeeTestDepartment() {
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction transaction = openSession.beginTransaction();
		
		Criteria criteria = openSession.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("department", "test"));
		criteria.setProjection(Projections.min("salary"));
		double minSalary = (double) criteria.uniqueResult();
		
		Criteria criteria2 = openSession.createCriteria(Employee.class);
		criteria2.add(Restrictions.eq("salary", minSalary));
		List<Employee> list = criteria2.list();
		
		for (Employee employee : list) {
			System.out.println(employee);
		}
		
		transaction.commit();
		
	}

	public void getTotalSalaryDevAndSupport() {
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction transaction = openSession.beginTransaction();
		
		Criteria criteria = openSession.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("department", "dev"));
		criteria.setProjection(Projections.sum("salary"));
		List list = criteria.list();
		System.out.println("Total salary Expenditure Dev Department : "+list);
		
		Criteria criteria2 = openSession.createCriteria(Employee.class);
		criteria2.add(Restrictions.eq("department", "support"));
		criteria2.setProjection(Projections.sum("salary"));
		List list2 = criteria2.list();
		
		
		System.out.println("Total salary Expenditure Dev Department : "+list);
		System.out.println("Total salary Expenditure Support Department : "+list2);
		
		
		
		transaction.commit();
	}

	public void getEmployeesOverAverageSalaryDevDepartment() {
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction transaction = openSession.beginTransaction();
		
		Criteria criteria = openSession.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("department", "dev"));
		criteria.setProjection(Projections.avg("salary"));
		double avgSalary = (double) criteria.uniqueResult();
		
		Criteria criteria2 = openSession.createCriteria(Employee.class);
		criteria2.add(Restrictions.eq("department", "dev"));
		criteria2.add(Restrictions.gt("salary", avgSalary));
		List<Employee> list = criteria2.list();
		
		for (Employee employee : list) {
			System.out.println(employee);
		}
		
		transaction.commit();
		
		
	}

	public void getTotalSalaryPuneLocation() {
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction transaction = openSession.beginTransaction();
		
		Criteria criteria = openSession.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("location", "Pune"));
		criteria.setProjection(Projections.sum("salary"));
		List list = criteria.list();
		System.out.println("Total salary Expenditure Pune Location : "+list);
		
		transaction.commit();
		
	}

}
