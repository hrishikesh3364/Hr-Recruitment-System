package com.Employee.HrRecruitmentSystem.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "companies")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    private String industry;

    @Column(nullable = false, length = 25)
    private String city;

    private String state;

    @Column(nullable = false, length = 20)
    private String country;

    @Column(length = 10)
    private String postalCode;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(length = 15)
    private String phoneNumber;

    private String website;

    private int employeeCount;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<Department> departments;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<Employee> employees;
}

