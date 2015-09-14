package com.springapp.repository;

import com.springapp.model.Person;
import org.springframework.data.repository.CrudRepository;

/**
 * Person repository.
 *
 * @author Sergey Cherepanov
 */
public interface PersonRepository extends CrudRepository<Person, Long> {}
