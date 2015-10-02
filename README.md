# SpringHelloWorld

[![Build Status](https://travis-ci.org/flexjoy/SpringHelloWorld.svg?branch=master)](https://travis-ci.org/flexjoy/SpringHelloWorld)

##Test project to lean Spring framework.

Project is a simple web-application that creates in memory H2 database with table `people` and following fields:
 
 - `id`
 - `name`
 - `age`
 
Web-application provides full CRUD operations with data for logged user `admin` only.
Also, project internationalization for Russian/English languages available.

1. Use `mvn jetty:run` command to start application.
2. Open <http://localhost:8080> url in your browser to use application. 
 

Used technology:

 - Spring Framework (MVC, Security, Data-JPA)
 - Maven
 - Jetty
 - JSP
 - Liquibase
 - H2 database
 - JDBC
 - JPA/Hibernate
 - JSR303
 - Hibernate Validator
 - Thymeleaf
 - TravisCI
 
