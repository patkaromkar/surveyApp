package com.regulus.app.survey.surveyapp;

import java.io.File;
import java.io.InputStream;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.regulus.app.survey.entities.SurveyStatus;

public class BasicHibTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Pass here the hibernate config file name
		final String hibernateConfigFileLocation 
			= "config/hibernate.cfg.xml";
		Logger logger = Logger.getLogger(BasicHibTest.class);
		
		final File f = new File(hibernateConfigFileLocation);
		logger.debug("The file is at location  = "+hibernateConfigFileLocation);
		logger.info("The file is at location  = "+hibernateConfigFileLocation);
		logger.error("The file is at location  = "+hibernateConfigFileLocation);
		logger.fatal("The file is at location  = "+hibernateConfigFileLocation);
		logger.trace("The file is at location  = "+hibernateConfigFileLocation);
		logger.warn("The file is at location  = "+hibernateConfigFileLocation);
		
		final Configuration cfg = new Configuration().configure(f);
		
		final StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
		serviceRegistryBuilder.applySettings(cfg.getProperties());
		final ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
		
		final SessionFactory sessionFactory = cfg.buildSessionFactory(serviceRegistry);
		
		final Session session = sessionFactory.openSession();
		
		try {
				session.beginTransaction();
				SurveyStatus surveyStatus = new SurveyStatus();
				surveyStatus.setSaSurveyStatusName("Open");
				session.save(surveyStatus);
				
				surveyStatus = new SurveyStatus();
				surveyStatus.setSaSurveyStatusName("Closed");
				session.save(surveyStatus);
				
				surveyStatus = new SurveyStatus();
				surveyStatus.setSaSurveyStatusName("Draft");
				session.save(surveyStatus);
				
				surveyStatus = new SurveyStatus();
				surveyStatus.setSaSurveyStatusName("Deleted");
				session.save(surveyStatus);
				
				session.getTransaction().commit();
		} catch(Exception e) {
			logger.error("Error occured !!! "+e.getMessage());
			session.getTransaction().rollback();
		} finally{
			session.close();
			StandardServiceRegistryBuilder.destroy(serviceRegistry);
		}
		
	}

}
