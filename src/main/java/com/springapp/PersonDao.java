package com.springapp;

import java.util.List;

/**
 * Person class DAO interface.
 *
 * @author Sergey Cherepanov
 */
public interface PersonDao {

    void insert(Person person);
    List<Person> selectAll();
}
