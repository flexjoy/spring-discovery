package com.springapp.config;

import com.springapp.PersonDao;
import com.springapp.PersonDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * DAO configuration.
 *
 * @author Sergey Cherepanov
 */
@Configuration
public class DaoConfig {

    @Autowired
    private DataSource dataSource;

    @Bean(name = "personDao")
    public PersonDao personDao() {
        return new PersonDaoImpl(dataSource);
    }
}
