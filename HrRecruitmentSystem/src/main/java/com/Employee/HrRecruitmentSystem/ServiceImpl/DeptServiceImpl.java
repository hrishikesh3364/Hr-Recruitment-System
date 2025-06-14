package com.Employee.HrRecruitmentSystem.ServiceImpl;

import com.Employee.HrRecruitmentSystem.DTO.DepartmentDto;
import com.Employee.HrRecruitmentSystem.Entity.Company;
import com.Employee.HrRecruitmentSystem.Entity.Department;
import com.Employee.HrRecruitmentSystem.ExceptionHandler.ResourceNotFoundException;
import com.Employee.HrRecruitmentSystem.Repository.CompanyRepository;
import com.Employee.HrRecruitmentSystem.Repository.DepartmentRepository;
import com.Employee.HrRecruitmentSystem.Services.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DeptServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final CompanyRepository companyRepository;
    private final ModelMapper modelMapper;

    @Override
    public DepartmentDto createDepartment(DepartmentDto dto) {
        Company company = companyRepository.findById(dto.getCompanyId())
                .orElseThrow(() -> new ResourceNotFoundException("Company not found with id: " + dto.getCompanyId()));

        Department department = Department.builder()
                .name(dto.getName())
                .company(company)
                .build();

        Department saved = departmentRepository.save(department);

        return mapToDto(saved);
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        return departmentRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentDto getDepartmentById(Long id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + id));

        return mapToDto(department);
    }

    private DepartmentDto mapToDto(Department department) {
        return DepartmentDto.builder()
                .id(department.getId())
                .name(department.getName())
                .companyId(department.getCompany().getId())
                .companyName(department.getCompany().getName())
                .build();
    }
}

