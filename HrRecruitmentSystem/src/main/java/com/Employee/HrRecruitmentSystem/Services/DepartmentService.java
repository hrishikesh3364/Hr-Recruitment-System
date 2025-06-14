package com.Employee.HrRecruitmentSystem.Services;

import com.Employee.HrRecruitmentSystem.DTO.DepartmentDto;

import java.util.List;

public interface DepartmentService {
    DepartmentDto createDepartment(DepartmentDto dto);
    List<DepartmentDto> getAllDepartments();
    DepartmentDto getDepartmentById(Long id);
}
