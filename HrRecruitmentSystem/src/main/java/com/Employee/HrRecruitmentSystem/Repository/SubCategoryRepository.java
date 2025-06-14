package com.Employee.HrRecruitmentSystem.Repository;

import com.Employee.HrRecruitmentSystem.Entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {
}
