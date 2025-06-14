package com.Employee.HrRecruitmentSystem.Annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PhoneNumberValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPhoneNumber {
    String message() default "Invalid phone number. Must be 10 to 15 digits, optionally starting with '+'";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
