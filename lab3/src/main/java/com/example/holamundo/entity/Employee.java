package com.example.holamundo.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.batch.BatchProperties;

import java.sql.Blob;
import java.sql.Date;

@Entity (name="employees")
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id", nullable = false)
    private Integer id;
    @Column(name="last_name", nullable = false)
    private String lastname;
    @Column(name = "first_name", nullable = false)
    private String firstname;
    private String email;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;
    /*@ManyToOne
    @JoinColumn(name="department_id")
    private Department department;*/



    /*private String email;
    private String password;
    private Date phonenumber;
    private Date hiredate;
    private String jobid;
    private String salary;



    private String enabled;*/


    /*
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EmployeeID")
    private int id;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String firstName;
    private String title;
    private String titleOfCourtesy;
    private Date birthDate;
    private Date hireDate;
    private String address;
    private String city;
    private String region;
    private String postalCode;
    private String country;
    private String homePhone;
    private String extension;
    @Lob
    private byte[] photo;
    @Column(nullable = false)
    private String notes;
    @OneToOne
    @JoinColumn(name = "reportsTo")
    private Employee manager;
    private String photoPath;
    private float salary;
    */


}
