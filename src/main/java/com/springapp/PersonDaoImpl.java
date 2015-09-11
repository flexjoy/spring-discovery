package com.springapp;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Person class DAO interface implementation.
 *
 * @author Sergey Cherepanov
 */
public class PersonDaoImpl implements PersonDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public long insert(Person person) {
        em.persist(person);
        return person.getId();
    }

    @Override
    public List<Person> selectAll() {
        return em.createQuery(
                "SELECT p FROM Person p", Person.class)
                .getResultList();
    }

    @Override
    public Person findById(long id) {
        return em.createQuery(
                "SELECT p FROM Person p WHERE p.id = :id", Person.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    @Transactional
    public void delete(long id) {
        int n = em.createQuery(
                "DELETE FROM Person p WHERE p.id = :id")
                .setParameter("id", id)
                .executeUpdate();
        System.out.println("DELETED entities: " + n);
    }
}
