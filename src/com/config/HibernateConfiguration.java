package com.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Employee;

public class HibernateConfiguration {
	public static final SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration();
		configuration.configure();
		configuration.addAnnotatedClass(Employee.class);
		return configuration.buildSessionFactory();
	}
}
