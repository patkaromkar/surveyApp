package com.regulus.app.survey.surveyapp;

import java.io.File;
import java.io.InputStream;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class BasicHibTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Pass here the hibernate config file name
		final String hibernateConfigFileLocation 
			= "config/hibernate.cfg.xml";
		final File f = new File(hibernateConfigFileLocation);
		
		final Configuration cfg = new Configuration().configure(f);
		
		final StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
		serviceRegistryBuilder.applySettings(cfg.getProperties());
		ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
		
		SessionFactory sessionFactory = cfg.buildSessionFactory(serviceRegistry);
		StandardServiceRegistryBuilder.destroy(serviceRegistry);
	}

}
