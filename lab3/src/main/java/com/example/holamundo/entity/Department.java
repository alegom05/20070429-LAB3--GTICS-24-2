package com.example.holamundo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name="departments")
@Getter
@Setter
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id", nullable = false)
    private int id;

    @Column(name = "department_name", nullable = false)
    private String department;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

}
