package com.Employee.HrRecruitmentSystem.Services;

import com.Employee.HrRecruitmentSystem.DTO.EmployeeDto;
import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto dto);
    List<EmployeeDto> getAllEmployees();
    EmployeeDto getEmployeeById(Long id);

    EmployeeDto updateEmployee(Long id, EmployeeDto dto);

    void deleteEmployee(Long id);
}
