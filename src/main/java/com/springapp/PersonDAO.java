package com.springapp;

import java.util.List;

/**
 * Person class DAO interface.
 *
 * @author Sergey Cherepanov
 */
public interface PersonDAO {

    public void Insert(Person person);
    public List<Person> SelectAll();
}
