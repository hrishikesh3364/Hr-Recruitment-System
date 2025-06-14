package com.Employee.HrRecruitmentSystem.DTO;

import com.Employee.HrRecruitmentSystem.Annotations.NullOrNotBlank;
import jakarta.validation.constraints.Min;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {


    private int employeeId;

    @NullOrNotBlank(message = "Name is required", isMandatory = "yes", min = 2, max = 100)
    private String name;

    @NullOrNotBlank(message = "Role is required", isMandatory = "yes", min = 2, max = 50)
    private String role;

    private Long companyId;

    @NullOrNotBlank(message = "Valid email is required", isEmail = "yes", isMandatory = "yes",min = 2, max = 50)
    private String email;

    private Long departmentId;

    private Long subDepartmentId;
}
