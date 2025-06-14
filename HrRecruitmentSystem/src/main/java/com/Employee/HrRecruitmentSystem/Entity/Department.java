package com.Employee.HrRecruitmentSystem.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "departments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false, length = 50)
        private String name;

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "company_id")
        private Company company;

        @OneToMany(fetch = FetchType.LAZY, mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<Employee> employees;

        @OneToMany(fetch = FetchType.LAZY, mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<SubCategory> subCategories;
}
