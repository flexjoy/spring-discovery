package com.springapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
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
        Map<String, Object> map = Collections.singletonMap("id", id);
        return jdbcTemplate.queryForObject(query, map, new personRowMapper());
    }

    private class personRowMapper implements RowMapper<Person>
    {
        @Override
        public Person mapRow(ResultSet resultSet, int i) throws SQLException {
            Person person = new Person();
            person.setId(resultSet.getInt("id"));
            person.setName(resultSet.getString("name"));
            person.setAge(resultSet.getInt("age"));
            return person;
        }
    }

    private static SqlParameterSource buildParameterSource(Person person) {
        Map<String, Object>  map = new HashMap<>();
        map.put("name", person.getName());
        map.put("age", person.getAge());
        return new MapSqlParameterSource(map);
    }
}
