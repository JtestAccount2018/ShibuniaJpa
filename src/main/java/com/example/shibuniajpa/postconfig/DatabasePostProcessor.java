package com.example.shibuniajpa.postconfig;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.testcontainers.containers.PostgreSQLContainer;

import javax.sql.DataSource;


@Configuration
public class DatabasePostProcessor implements BeanPostProcessor {

    public static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:11.1")
            .withReuse(true)
            .withDatabaseName("tst");

    static {
        postgreSQLContainer.start();
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equals("dataSource")){
            HikariDataSource dataSource = (HikariDataSource) bean;
            dataSource.setPassword(postgreSQLContainer.getPassword());
            dataSource.setUsername(postgreSQLContainer.getUsername());
            dataSource.setJdbcUrl(postgreSQLContainer.getJdbcUrl());
            System.out.println(postgreSQLContainer.getPassword());
            System.out.println(postgreSQLContainer.getUsername());
            System.out.println(postgreSQLContainer.getJdbcUrl());
            return bean;
        }
        return bean;
    }
}
