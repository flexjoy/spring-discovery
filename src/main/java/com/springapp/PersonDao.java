package com.springapp;

import java.util.List;

/**
 * Person class DAO interface.
 *
 * @author Sergey Cherepanov
 */
public interface PersonDao {

    long insert(Person person);
    List<Person> selectAll();
    Person selectPerson(long id);
}
