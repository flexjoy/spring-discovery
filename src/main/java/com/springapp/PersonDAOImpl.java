package com.springapp;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Person class DAO interface implementation.
 *
 * @author Sergey Cherepanov
 */
public class PersonDAOImpl implements PersonDAO {

    private JdbcTemplate jdbcTemplate;

    public PersonDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void Insert(Person person) {

        String query = "INSERT INTO people (name, age) VALUES (?, ?)";
        Object[] objects = new Object[] { person.getName(), person.getAge()};
        jdbcTemplate.update(query, objects);
    }

    @Override
    public List<Person> SelectAll() {

        String query = "SELECT name, age FROM people";
        BeanPropertyRowMapper mapper = new BeanPropertyRowMapper(Person.class);
        return jdbcTemplate.query(query, mapper);
    }
}
