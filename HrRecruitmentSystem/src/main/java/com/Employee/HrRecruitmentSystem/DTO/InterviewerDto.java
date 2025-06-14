package com.Employee.HrRecruitmentSystem.DTO;

import com.Employee.HrRecruitmentSystem.Annotations.NullOrNotBlank;
//import com.Employee.HrRecruitmentSystem.Annotations.ValidPhoneNumber;
import com.Employee.HrRecruitmentSystem.Annotations.ValidPhoneNumber;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InterviewerDto {

    @Min(value = 1, message = "Employee ID must be greater than 0")
    private int employeeId;

    @NullOrNotBlank(message = "Name is required", isMandatory = "yes", min = 2, max = 100)
    private String name;

    @NullOrNotBlank(message = "Valid email is required", isMandatory = "yes", isEmail = "yes")
    private String email;

    @ValidPhoneNumber
    @NullOrNotBlank(message = "Phone number is required", isMandatory = "yes", min = 10, max = 15)
    private String phoneNumber;

    @NullOrNotBlank(message = "Department is required", isMandatory = "yes", min = 2, max = 50)
    private String department;

    @NullOrNotBlank(message = "Designation is required", isMandatory = "yes", min = 2, max = 50)
    private String designation;

    @Min(value = 1, message = "Batch number must be at least 1")
    private int batchNumber;

    @NotNull(message = "Interview date is required")
    private LocalDate date;
}


