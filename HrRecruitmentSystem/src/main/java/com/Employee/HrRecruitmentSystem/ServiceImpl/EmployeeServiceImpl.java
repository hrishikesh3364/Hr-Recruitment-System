package com.Employee.HrRecruitmentSystem.ServiceImpl;

import com.Employee.HrRecruitmentSystem.DTO.EmployeeDto;
import com.Employee.HrRecruitmentSystem.Entity.Company;
import com.Employee.HrRecruitmentSystem.Entity.Department;
import com.Employee.HrRecruitmentSystem.Entity.Employee;
import com.Employee.HrRecruitmentSystem.Entity.SubCategory;
import com.Employee.HrRecruitmentSystem.ExceptionHandler.ResourceNotFoundException;
import com.Employee.HrRecruitmentSystem.Repository.CompanyRepository;
import com.Employee.HrRecruitmentSystem.Repository.DepartmentRepository;
import com.Employee.HrRecruitmentSystem.Repository.EmployeeRepository;
import com.Employee.HrRecruitmentSystem.Repository.SubCategoryRepository;
import com.Employee.HrRecruitmentSystem.Services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final CompanyRepository companyRepository;
    private final DepartmentRepository departmentRepository;
    private final SubCategoryRepository subCategoryRepository;
    private final ModelMapper modelMapper;

    @Override
    public EmployeeDto createEmployee(EmployeeDto dto) {
        Company company = companyRepository.findById(dto.getCompanyId())
                .orElseThrow(() -> new ResourceNotFoundException("Company not found with ID: " + dto.getCompanyId()));

        Department department = departmentRepository.findById(dto.getDepartmentId())
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with ID: " + dto.getDepartmentId()));

        SubCategory subCategory = subCategoryRepository.findById(dto.getSubDepartmentId())
                .orElseThrow(() -> new ResourceNotFoundException("SubCategory not found with ID: " + dto.getSubDepartmentId()));

        Employee employee = Employee.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .role(dto.getRole())
                .company(company)
                .department(department)
                .subCategory(subCategory)
                .build();

        Employee saved = employeeRepository.save(employee);
        return modelMapper.map(saved, EmployeeDto.class);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(emp -> modelMapper.map(emp, EmployeeDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with ID: " + id));
        return modelMapper.map(employee, EmployeeDto.class);
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto dto) {
        Employee existing = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with ID: " + id));

        Company company = companyRepository.findById(dto.getCompanyId())
                .orElseThrow(() -> new ResourceNotFoundException("Company not found with ID: " + dto.getCompanyId()));

        Department department = departmentRepository.findById(dto.getDepartmentId())
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with ID: " + dto.getDepartmentId()));

        SubCategory subCategory = subCategoryRepository.findById(dto.getSubDepartmentId())
                .orElseThrow(() -> new ResourceNotFoundException("SubCategory not found with ID: " + dto.getSubDepartmentId()));

        existing.setName(dto.getName());
        existing.setEmail(dto.getEmail());
        existing.setRole(dto.getRole());
        existing.setCompany(company);
        existing.setDepartment(department);
        existing.setSubCategory(subCategory);

        Employee updated = employeeRepository.save(existing);
        return modelMapper.map(updated, EmployeeDto.class);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with ID: " + id));
        employeeRepository.delete(employee);
    }
}
