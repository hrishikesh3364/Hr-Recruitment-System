package com.Employee.HrRecruitmentSystem.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "subcategories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @ElementCollection
    @CollectionTable(name = "subcategory_roles", joinColumns = @JoinColumn(name = "subcategory_id"))
    @Column(name = "role")
    private List<String> jobRoles;
}
