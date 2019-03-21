package org.csr.spring.config.data;

import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import oracle.jdbc.pool.OracleDataSource;

@Configuration
@EnableTransactionManagement
@PropertySource({ "classpath:persistence-orcl.properties" })
@ComponentScan({ "org.csr.spring.model" })
public class PersistanceConfig {

	private Logger logger = LogManager.getLogger("SPRING_BASE_WEB_APP_LOGGER");

	@Autowired
	private Environment env;

	@Bean
	public LocalSessionFactoryBean sessionFactory() throws SQLException {
		logger.debug("sessionFactory...");
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(connectionDataSource());
		sessionFactory.setPackagesToScan(new String[] { "org.csr.spring.model" });
		sessionFactory.setHibernateProperties(hibernateProperties());

		return sessionFactory;
	}

	@Bean
	public DataSource connectionDataSource() throws SQLException {
		logger.debug("restDataSource...");
		OracleDataSource dataSource = new OracleDataSource();
		logger.debug(String.format("jdbc.url %s", env.getProperty("jdbc.url")));
		dataSource.setURL(env.getProperty("jdbc.url"));
		logger.debug(String.format("jdbc.user %s", env.getProperty("jdbc.user")));
		dataSource.setUser(env.getProperty("jdbc.user"));
		logger.debug(String.format("jdbc.pass %s", env.getProperty("jdbc.pass")));
		dataSource.setPassword(env.getProperty("jdbc.pass"));

		return dataSource;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		logger.debug("transactionManager...");
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);

		return txManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		logger.debug("exceptionTranslation...");
		return new PersistenceExceptionTranslationPostProcessor();
	}

	private Properties hibernateProperties() {
		logger.debug("hibernateProperties...");
		Properties properties = new Properties();
		logger.debug(String.format("hibernate.dialect %s", env.getProperty("hibernate.dialect")));
		properties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		logger.debug(String.format("hibernate.show_sql %s", env.getProperty("hibernate.show_sql")));
		properties.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		return properties;
	}
}
