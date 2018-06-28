package by.htp.carparking.repositories;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

import org.hibernate.jpa.HibernatePersistenceProvider;

@Configuration
@ComponentScan
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { "by.htp.carparking.repositories" })
public class SpringDataConfig {

	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(com.mysql.cj.jdbc.Driver.class.getName());
		dataSource.setUrl("jdbc:mysql://localhost:2016/carparking?useTimezone=true&serverTimezone=UTC");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(dataSource());
		factory.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		// factory.setJpaDialect();

		Properties properties = new Properties();
		// properties.setProperty("hibernate.hbm2ddl.auto", "create");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		properties.setProperty("show_sql", "true");
		factory.setJpaProperties(properties);

		factory.setPackagesToScan("by.htp.carparking");
		return factory;
	}

	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}

}
