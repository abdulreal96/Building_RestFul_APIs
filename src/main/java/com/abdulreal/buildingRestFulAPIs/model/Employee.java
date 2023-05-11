package com.abdulreal.buildingRestFulAPIs.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="emp_id")
    private Long empId;

    @Column(name="first_name")
    @NotNull(message = "first name can not be null")
    private String firstName;

    @Column(name="last_name")
    @NotNull(message = "last name can not be null")
    private String lastName;

    @Email(message = "email must end with example '@gmail.com' ")
    @Column(name="email_id")
    private String emailId;
}

