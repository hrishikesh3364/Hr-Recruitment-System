package com.Employee.HrRecruitmentSystem.DTO;

import com.Employee.HrRecruitmentSystem.Annotations.NullOrNotBlank;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PositionDto {

    @Min(value = 1, message = "ID must be greater than 0")
    private int id;

    @NullOrNotBlank(message = "Title is required", isMandatory = "yes", min = 2, max = 100)
    private String title;

    @NullOrNotBlank(message = "Location is required", isMandatory = "yes", min = 2, max = 100)
    private String location;

    @Min(value = 1, message = "Number of openings must be at least 1")
    private int numberOfOpenings;

    @NullOrNotBlank(message = "Description is required", isMandatory = "yes", min = 10, max = 500)
    private String description;

    @NotNull(message = "Department ID is required")
    private Long departmentID;

    @NotNull(message = "Sub-department ID is required")
    private Long subDepartmentId;

    private LocalDateTime postedDate;

    private LocalDateTime closingDate;

    @NullOrNotBlank(message = "Status is required", isMandatory = "yes", min = 2, max = 50)
    private String status;
}
