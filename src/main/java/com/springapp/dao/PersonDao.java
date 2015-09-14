package com.springapp.dao;

import com.springapp.model.Person;

import java.util.List;

/**
 * Person class DAO interface.
 *
 * @author Sergey Cherepanov
 */
public interface PersonDao {

    long insert(Person person);
    List<Person> selectAll();
    Person findById(long id);
    void delete(long id);
    void edit(Person person);
}
