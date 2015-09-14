package com.springapp.config;

import com.springapp.dao.PersonDao;
import com.springapp.dao.PersonDaoImpl;
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
