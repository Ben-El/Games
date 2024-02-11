package com.example.simpleapp.dataaccess.entities;

import jakarta.persistence.*;
import lombok.Data;

// We need the @Data annotation due to how the JSON serialization works in Spring.
// The @Data annotation from Lombok automatically generates the getter and setter methods for all fields in the class.
// When we return a list of User objects from our controller method, Spring uses Jackson library
// under the hood to convert these objects into JSON format.
// The process involves calling the getter methods of the object to retrieve the values of its properties.
// If the getter methods are not present, Jackson cannot access the property values,
// and because of that we'll get an empty JSON objects in the response.

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;
}