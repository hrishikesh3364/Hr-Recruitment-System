package com.Employee.HrRecruitmentSystem.Services;

import com.Employee.HrRecruitmentSystem.DTO.SubCategoryDto;

import java.util.List;

public interface SubCategoryService {
    SubCategoryDto createSubCategory(SubCategoryDto dto);
    List<SubCategoryDto> getAllSubCategories();
    SubCategoryDto getSubCategoryById(Long id);
}
