package com.varunbehl.spring.config;

import com.mysql.jdbc.Driver;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;

@Configuration
@MapperScan("com.varunbehl.spring.persistence")
class DataConfig {

    @Bean
    private DataSource dataSource() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(Driver.class);
        dataSource.setUsername("root");
        dataSource.setUrl("jdbc:mysql://localhost:8889/gym");
        dataSource.setPassword("Pulsur");

        // create a table and populate some data
//		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//		System.out.println("Creating tables");
//		jdbcTemplate.execute("drop table users if exists");
//		jdbcTemplate.execute(
//				"create table users(id serial, firstName varchar(255), lastName varchar(255), email varchar(255))");
//		jdbcTemplate.update("INSERT INTO users(firstName, lastName, email) values (?,?,?)", "Mike", "Lanyon",
//				"lanyonm@gmail.com");

        return dataSource;
    }

    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory() {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setTypeAliasesPackage("com.varunbehl.spring.model");
        return sessionFactory;
    }
}