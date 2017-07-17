package com.regulus.app.survey.dao.iface;

import java.io.File;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.regulus.app.survey.exceptions.SurveyAppDALException;
import com.regulus.app.survey.util.SAConstants;

/**
 * This is an abstract class for DAO.
 * This class contains the common functionality needed by all DAOs.
 * Like initializing a SessionFactory
 * 
 * @author Omkar P
 *
 */
public abstract class AbstractSurveyAppDAO {

	private final Logger logger = Logger.getLogger(AbstractSurveyAppDAO.class);
	
	protected String hibConfigLocation = "config/hibernate.cfg.xml";
	protected Configuration cfg = null;
	
	protected StandardServiceRegistryBuilder serviceRegistryBuilder = null;
	
	protected ServiceRegistry serviceRegistry = null;
	
	protected SessionFactory sessionFactory = null;
	
	protected Session session = null;
	
	protected void init(){
		logger.debug("Start of init()");

		if (cfg == null) {
			logger.debug("DAO will use the Hibernate configuration from the file = "+this.hibConfigLocation);
			final File f = new File(this.hibConfigLocation);
			this.cfg = new Configuration().configure(f);
			
			this.serviceRegistryBuilder = new StandardServiceRegistryBuilder();
			serviceRegistryBuilder.applySettings(cfg.getProperties());
			
			this.serviceRegistry = serviceRegistryBuilder.build();
			
			this.sessionFactory = cfg.buildSessionFactory(serviceRegistry);
			this.session = sessionFactory.openSession();
		}
		
		logger.debug("End of init()");

	}
	
	protected void closeSession() {
		logger.debug("Start of closeSession()");
		try {
			logger.info("Attempting to close the session");
			this.session.close();
			logger.info("Session is closed successfully");
		}catch (Exception e) {
			throw new SurveyAppDALException(SAConstants.DAL_EX_SESSION_NOT_CREATED_MSG, e);
		}
		logger.debug("End of closeSession()");
	}
	
	public void closeDAO() {
		logger.debug("Start of closeDAO()");
		if (serviceRegistry != null) {
			logger.info("Attempting to close the DAO...");
			this.closeSession();
			StandardServiceRegistryBuilder.destroy(serviceRegistry);
			logger.info("DAO is closed successfully");
		}
		logger.debug("End of closeDAO()");

	}
	
}
