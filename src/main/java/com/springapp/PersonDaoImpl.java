package com.springapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Person class DAO interface implementation.
 *
 * @author Sergey Cherepanov
 */
public class PersonDaoImpl implements PersonDao {

    @Autowired
    private MessageSource messageSource;

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public PersonDaoImpl(DataSource dataSource) {
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public long insert(Person person) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String query = "INSERT INTO people (name, age) VALUES (:name, :age)";
        jdbcTemplate.update(query, buildParameterSource(person), keyHolder);
        return keyHolder.getKey().longValue();
    }

    @Override
    public List<Person> selectAll() {
        String query = "SELECT id, name, age FROM people";
        BeanPropertyRowMapper mapper = new BeanPropertyRowMapper(Person.class);
        return jdbcTemplate.query(query, mapper);
    }

    @Override
    public Person findById(long id) {
        String query = "SELECT id, name, age FROM people WHERE id = :id";
        Map<String, Long> map = new HashMap<>();
        map.put("id", id);
        BeanPropertyRowMapper mapper = new BeanPropertyRowMapper(Person.class);
        return (Person)jdbcTemplate.queryForObject(query, map, mapper);
    }

    private static SqlParameterSource buildParameterSource(Person person) {
        Map<String, Object>  map = new HashMap<>();
        map.put("name", person.getName());
        map.put("age", person.getAge());
        return new MapSqlParameterSource(map);
    }
}
