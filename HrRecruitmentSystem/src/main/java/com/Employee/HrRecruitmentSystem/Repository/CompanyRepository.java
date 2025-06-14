package com.Employee.HrRecruitmentSystem.Repository;

import com.Employee.HrRecruitmentSystem.Entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    boolean existsByEmail(String email);

}
