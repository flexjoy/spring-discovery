package com.springapp;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Person class
 *
 * @author Sergey Cherepanov
 */
public class Person {

    @NotBlank(message = "ФИО должно быть задано!")
    @Length(min = 3, max = 50, message = "ФИО должно быть от 3 до 50 символов!")
    private String name;

    @NotNull(message = "Возраст должен быть задан!")
    @Digits(integer = 3, fraction = 0, message = "Возраст должен быть числом от 1 до 3 цифр!")
    @Min(value = 1, message = "Возраст должен быть больше 0!")
    @Max(value = 150, message = "Возраст должен быть меньше 150!")
    private Integer age;

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
