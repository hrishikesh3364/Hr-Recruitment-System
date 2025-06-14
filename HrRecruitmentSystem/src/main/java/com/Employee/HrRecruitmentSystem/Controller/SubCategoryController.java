package com.Employee.HrRecruitmentSystem.Controller;

import com.Employee.HrRecruitmentSystem.DTO.SubCategoryDto;
import com.Employee.HrRecruitmentSystem.Services.SubCategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "SubCategory Controller", description = "Operations related to job subcategories")
@RestController
@RequestMapping("/api/subcategories")
@RequiredArgsConstructor
public class SubCategoryController {

    private final SubCategoryService subCategoryService;

    @Operation(summary = "Create a subcategory")
    @PostMapping
    public ResponseEntity<SubCategoryDto> create(@Valid @RequestBody SubCategoryDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(subCategoryService.createSubCategory(dto));
    }

    @Operation(summary = "Get all subcategories")
    @GetMapping
    public ResponseEntity<List<SubCategoryDto>> getAll() {
        return ResponseEntity.ok(subCategoryService.getAllSubCategories());
    }

    @Operation(summary = "Get subcategory by ID")
    @GetMapping("/{id}")
    public ResponseEntity<SubCategoryDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(subCategoryService.getSubCategoryById(id));
    }
}
