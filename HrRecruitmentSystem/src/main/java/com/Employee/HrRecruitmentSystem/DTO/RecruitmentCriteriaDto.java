package com.Employee.HrRecruitmentSystem.DTO;

import jakarta.validation.constraints.Min;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecruitmentCriteriaDto {

    @Min(value = 1, message = "ID must be greater than 0")
    private int id;

    private Long positionId;
    private int experienceYears;
    private List<String> skills;
    private List<String> preferredDegrees;

}