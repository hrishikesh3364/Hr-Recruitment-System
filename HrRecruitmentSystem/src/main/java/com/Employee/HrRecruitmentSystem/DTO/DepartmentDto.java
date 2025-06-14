package com.Employee.HrRecruitmentSystem.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Department DTO")
public class DepartmentDto {

    @Schema(description = "Department ID", example = "1")
    private Long id;

    @NotBlank(message = "Department name is required")
    @Schema(description = "Name of the department", example = "Engineering")
    private String name;

    @Schema(description = "Company ID this department belongs to", example = "1")
    private Long companyId;

    @Schema(description = "Company name", example = "OpenAI")
    private String companyName;
}
