package com.springapp.repository;

import com.springapp.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Person repository.
 *
 * @author Sergey Cherepanov
 */
@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {}
