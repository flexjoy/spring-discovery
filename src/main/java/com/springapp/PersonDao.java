package com.springapp;

import java.util.List;

/**
 * Person class DAO interface.
 *
 * @author Sergey Cherepanov
 */
public interface PersonDao {

    long insert(Person person) throws Exception;
    List<Person> selectAll();
    Person findById(long id) throws Exception;
}
