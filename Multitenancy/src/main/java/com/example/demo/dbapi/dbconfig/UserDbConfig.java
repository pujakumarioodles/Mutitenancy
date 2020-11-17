package com.example.demo.dbapi.dbconfig;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef="entityManagerFactory",
basePackages="com.example.demo.dbapi.MyuserRepo",transactionManagerRef="transactionManager")
public class UserDbConfig {
	

	@Primary
	@ConfigurationProperties(prefix="spring.user.datasource")
	@Bean("datasource")
	public DataSource datasource()
	{
		return (DataSource) DataSourceBuilder.create().build();
	}
	
	@Bean("entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean
	entityManagerFactoryBean(EntityManagerFactoryBuilder builder, @Qualifier DataSource datasource)
	{
		Map<String, Object> properties=new HashMap<>();
		properties.put("hibernate.ddl-auto", "update");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		
	return builder.dataSource(datasource).properties(properties).packages("com.example.demo.dbapi.MyUser").
			persistenceUnit("Myuser").build();	
	}
	@Bean("transactionManager")
	@Primary
	public PlatformTransactionManager transactionManager(@Qualifier EntityManagerFactory entityManagerFactory)
	{
		return new JpaTransactionManager(entityManagerFactory);
		
	}

}
