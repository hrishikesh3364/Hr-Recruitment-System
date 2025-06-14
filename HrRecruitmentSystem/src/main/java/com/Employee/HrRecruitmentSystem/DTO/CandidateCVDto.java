package com.Employee.HrRecruitmentSystem.DTO;

import com.Employee.HrRecruitmentSystem.Annotations.NullOrNotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CandidateCVDto {

    @NullOrNotBlank(message = "Name is required", isMandatory = "yes", min = 2, max = 100)
    private String name;

    @NullOrNotBlank(message = "Email is required and must be valid", isEmail = "yes", isMandatory = "yes", min = 2, max = 100)
    private String email;

    @Pattern(regexp = "^\\+?[0-9]{7,15}$", message = "Invalid phone number")
    private String phoneNumber;

    private String resumeUrl;

    private String resumeFileType;

    private Long positionId;
}
