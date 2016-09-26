package fashionplussBackEnd.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import fashionplussBackEnd.model.Blog;
import fashionplussBackEnd.model.Role;
import fashionplussBackEnd.model.UserDetails;
import fashionplussBackEnd.model.UsersRole;



@Configuration
@ComponentScan("OwlPostBackend")
@EnableTransactionManagement
public class ApplicationContextConfig {
	

    
    @Bean(name = "dataSource")
    public DataSource getDataSource() {
    	BasicDataSource dataSource = new BasicDataSource();
    	dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
    	dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
    	dataSource.setUsername("OWLPOST");
    	dataSource.setPassword("ROOT");
    	
    	return dataSource;
    }
    
    
    private Properties getHibernateProperties() {
    	Properties properties = new Properties();
    	properties.setProperty("hibernate.hbm2ddl.auto", "update");
    	properties.put("hibernate.show_sql", "true");
    	properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
    	return properties;
    }
    
    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) {
    	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
    	sessionBuilder.addProperties(getHibernateProperties());
    	
    	
    	sessionBuilder.addAnnotatedClasses(Blog.class);
    	//sessionBuilder.addAnnotatedClasses(UserProfile.class);
    	sessionBuilder.addAnnotatedClasses(Role.class);
    	sessionBuilder.addAnnotatedClasses(UsersRole.class);
    	sessionBuilder.addAnnotatedClasses(UserDetails.class);
    	
    
    	
    	return sessionBuilder.buildSessionFactory();
    	
    }
    
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(
			SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(
				sessionFactory);

		return transactionManager;
	}
}
