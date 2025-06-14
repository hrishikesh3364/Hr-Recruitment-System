package com.Employee.HrRecruitmentSystem.DTO;

import com.Employee.HrRecruitmentSystem.Annotations.NullOrNotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDto {

    private Long id;

    @NullOrNotBlank(message = "Name is required", isMandatory = "yes", min = 2, max = 100)
    private String name;

    private String industry;

    @NullOrNotBlank(message = "City is required", min = 2, max = 25)
    private String city;

    @NullOrNotBlank(isMandatory = "No")
    private String state;

    @NullOrNotBlank(message = "Country is required", min = 2, max = 20)
    private String country;

    @Pattern(regexp = "^[a-zA-Z0-9\\s-]{3,10}$", message = "Invalid postal code")
    private String postalCode;

    @NullOrNotBlank(message = "Email is required and must be valid", isEmail = "yes", isMandatory = "yes", min = 5, max = 100)
    private String email;

    @Pattern(regexp = "^\\+?[0-9]{7,15}$", message = "Invalid phone number")
    private String phoneNumber;

    private String website;

    private int employeeCount;
}


