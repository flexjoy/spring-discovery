package com.springapp.config;

import com.springapp.PersonDao;
import com.springapp.PersonDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * DAO configuration.
 *
 * @author Sergey Cherepanov
 */
@Configuration
public class DaoConfig {

    @Bean(name = "personDao")
    public PersonDao personDao() {
        return new PersonDaoImpl();
    }
}
