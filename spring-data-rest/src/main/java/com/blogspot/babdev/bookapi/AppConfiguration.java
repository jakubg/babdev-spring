package com.blogspot.babdev.bookapi;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.ejb.HibernatePersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
public class AppConfiguration {

	
	private static final String PROPERTY_NAME_DATABASE_DRIVER = "com.mysql.jdbc.Driver";  
    private static final String PROPERTY_NAME_DATABASE_PASSWORD = "oca123";  
    private static final String PROPERTY_NAME_DATABASE_URL = "mysql://root:secret@localhost/myDatabase";  
    private static final String PROPERTY_NAME_DATABASE_USERNAME = "oca";  
          
    private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "org.hibernate.dialect.MySQLDialectdialect";  
    private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "true";  
    private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN ="com.blogspot.*"; 
	
	
    @Resource
    private Environment env;
    
    @Bean
    public DataSource dataSource() {
    	
    	
        DriverManagerDataSource dataSource = new DriverManagerDataSource();  
        
        dataSource.setDriverClassName(env.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));  
        dataSource.setUrl(env.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));  
        dataSource.setUsername(env.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));  
        dataSource.setPassword(env.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));  
          
        
    	
//        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
//        return builder.setType(EmbeddedDatabaseType.HSQL).build();
//        
        return dataSource; 
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        /*HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabase(Database.HSQL);
        vendorAdapter.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan(getClass().getPackage().getName());
        factory.setDataSource(dataSource());

        return factory;*/
    	
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();  
        entityManagerFactoryBean.setDataSource(dataSource());  
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistence.class);  
        entityManagerFactoryBean.setPackagesToScan(env.getRequiredProperty(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN));  
                          
        entityManagerFactoryBean.setJpaProperties(hibProperties());  
          
        return entityManagerFactoryBean; 
    }

//    @Bean
//    public PlatformTransactionManager transactionManager() {
//        return new JpaTransactionManager();
//    }
//    
    
    
    private Properties hibProperties() {  
        Properties properties = new Properties();  
        properties.put(PROPERTY_NAME_HIBERNATE_DIALECT, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));  
        properties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));  
        return properties;          
    }  
  
	@Bean  
	public JpaTransactionManager transactionManager() {  
	        JpaTransactionManager transactionManager = new JpaTransactionManager();  
	        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());  
	        return transactionManager;  
	}  
}
