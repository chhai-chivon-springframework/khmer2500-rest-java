package com.khmer2500.rest.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import com.khmer2500.rest.entities.Category;
import com.khmer2500.rest.entities.User;


public class HibernateUtil {
	
	private static final SessionFactory sessionFactory = buildSessionFactory();
	
	// hibernate.cfg.xml
	 /*private static SessionFactory buildSessionFactory(){
		try{
			Configuration configuration = new Configuration();
			return configuration
					.buildSessionFactory(new StandardServiceRegistryBuilder()
							.applySettings(configuration.getProperties())
							.build());
		}catch(Exception ex){
			ex.printStackTrace();
			throw new RuntimeException("There was an error building the factory.");
		}
 	}*/
	// hibernate.properties
	private static SessionFactory buildSessionFactory(){
		try{
			Configuration configuration = new Configuration();
			configuration.addAnnotatedClass(Category.class);
			configuration.addAnnotatedClass(User.class);
			
			//configuration.addPackage("com.khmer2500.rest.entities");
			return configuration.buildSessionFactory(new StandardServiceRegistryBuilder().build());
		}catch(Exception ex){
			ex.printStackTrace();
			throw new RuntimeException("There was an error building the factory.");
		}
	}
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
}
