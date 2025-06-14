package com.Employee.HrRecruitmentSystem.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data@Getter
@Setter
@Builder@AllArgsConstructor
@NoArgsConstructor
public class ScreeningResultDto {

    @Min(value = 1, message = "ID must be greater than 0")
    private int id;

    @NotNull(message = "Position ID must not be null")
    private Long positionId;

    @NotBlank(message = "Screening stage is required")
    private String screeningStage;

    @NotBlank(message = "Status is required")
    private String status;

    private boolean selected;

    private String nextRoundType;

    private String rejectionReason;
}
