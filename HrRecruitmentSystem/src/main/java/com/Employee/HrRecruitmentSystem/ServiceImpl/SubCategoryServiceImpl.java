package com.Employee.HrRecruitmentSystem.ServiceImpl;

import com.Employee.HrRecruitmentSystem.DTO.SubCategoryDto;
import com.Employee.HrRecruitmentSystem.Entity.Department;
import com.Employee.HrRecruitmentSystem.Entity.SubCategory;
import com.Employee.HrRecruitmentSystem.ExceptionHandler.ResourceNotFoundException;
import com.Employee.HrRecruitmentSystem.Repository.DepartmentRepository;
import com.Employee.HrRecruitmentSystem.Repository.SubCategoryRepository;
import com.Employee.HrRecruitmentSystem.Services.SubCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubCategoryServiceImpl implements SubCategoryService {

    private final SubCategoryRepository subCategoryRepository;
    private final DepartmentRepository departmentRepository;

    @Override
    public SubCategoryDto createSubCategory(SubCategoryDto dto) {
        Department department = departmentRepository.findById(dto.getSubDepartmentId())
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + dto.getSubDepartmentId()));

        SubCategory subCategory = SubCategory.builder()
                .name(dto.getName())
                .department(department)
                .jobRoles(dto.getJobRoles())
                .build();

        SubCategory saved = subCategoryRepository.save(subCategory);
        return mapToDto(saved);
    }

    @Override
    public List<SubCategoryDto> getAllSubCategories() {
        return subCategoryRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public SubCategoryDto getSubCategoryById(Long id) {
        SubCategory subCategory = subCategoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SubCategory not found with id: " + id));

        return mapToDto(subCategory);
    }

    private SubCategoryDto mapToDto(SubCategory entity) {
        return SubCategoryDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .subDepartmentId(entity.getDepartment().getId())
                .subDepartmentName(entity.getDepartment().getName())
                .jobRoles(entity.getJobRoles())
                .build();
    }
}
