package com.Employee.HrRecruitmentSystem.DTO;

import com.Employee.HrRecruitmentSystem.Annotations.NullOrNotBlank;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InterviewBatchDto {

    @Min(value = 1, message = "Batch ID must be greater than 0")
    private int id;

    @NotNull(message = "Date is required")
    private LocalDate date;

    @Min(value = 1, message = "Batch number must be at least 1")
    private int batchNumber;

    @NullOrNotBlank(message = "Time slot is required", isMandatory = "yes", min = 4, max = 50)
    private String timeSlot;

    @NotNull(message = "Position ID is required")
    private Long positionId;
}

