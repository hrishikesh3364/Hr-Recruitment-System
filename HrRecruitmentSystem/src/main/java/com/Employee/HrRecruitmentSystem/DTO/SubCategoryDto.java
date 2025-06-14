package com.Employee.HrRecruitmentSystem.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "SubCategory DTO")
public class SubCategoryDto {

    @Schema(description = "Subcategory ID", example = "1")
    private Long id;

    @NotBlank(message = "Subcategory name is required")
    @Schema(description = "Name of the subcategory", example = "Java Developer")
    private String name;

    @Schema(description = "SubDepartment ID", example = "2")
    private Long subDepartmentId;

    @Schema(description = "SubDepartment name", example = "Backend Development")
    private String subDepartmentName;

    @Schema(description = "List of job roles")
    private List<String> jobRoles;
}
