package com.springapp;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Person class.
 *
 * @author Sergey Cherepanov
 */
@Entity
@Table(name = "people")
public class Person {

    @Id
    @GeneratedValue
    private long id;

    @NotBlank
    @Length(min = 3, max = 50)
    private String name;

    @NotNull
    @Digits(integer = 3, fraction = 0)
    @Min(value = 1)
    @Max(value = 150)
    private Integer age;

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
