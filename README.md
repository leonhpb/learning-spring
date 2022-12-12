# learning-spring
My personal repo for storing information and examples while learning Spring.

## What is Spring?
* Spring is a Java Framework
* Open-source
* Makes it easier to make Java Applications
* Offers resources and modules needed for a variety of applications:
    - Security
    - Logging
    - Connection to DBs
    - Metrics
    - Many others
* Easy to learn

## How to Start a Spring Project
Go to https://start.spring.io/ and configure a new project

## Example Project
Application with the following layers:
* API
* Service
* Data Access
* Database

In this example project, we have a simple system that can do CRUD operations on students. These operations can be done through HTTP requests.

The project follows an N-tier architecture, divided in Controller, Service, Data Access. The controller layer communicates with the user through HTTP and the Data Access Layer communicates with a dataase as expected.

## On the Code
Spring uses annotations and other components to add/automate special funcionalities to the java project. Here are some of them:

* @SpringBootApplication - For the main application class
* SpringApplication.run(Application.class, args) - To start the Spring Boot Application
* @RestController - Simplifies the creation of RESTful web services, combines @Controller and @ResponseBody
* @GetMapping, @PostMapping, @PutMapping, @DeleteMapping - Maps method or class to GET, POST, PUT or DELETE HTTP methods respectively
* @RequestMapping - Same as above but generic, for all http requests
* @Autowired - Automatically fills constructor arguments with instances of the objects needed (objects need to be Spring components)
* @Component - for a Spring component class
* @Service - A component which is explicitly a service
* @Entity - JPA stablishes a connection between this class and a table with same name in DB
* @Table - To map a class to DB (entity for hybernate, table for the table)
* Example annotations for an id attribute in an entity-table class, 
    - @Id
    - @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    - @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
  )
* @Repository - for a repository class which is our interface to database
* @Configuration - class that defines beans. in the example there is a bean which pre-loads db values
* @Bean - For beans. Beans are objects instantiated and managed from Spring itself
* @Transient - For attributes that are not to be stored on DB
* @Autowired - Connects automatically method parameters/class attributes to objects managed by Spring (annotated by @Component/@Service/@Controller/@Repository/@Bean)


