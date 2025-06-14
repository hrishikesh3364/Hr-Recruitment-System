package com.Employee.HrRecruitmentSystem.Annotations;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


    public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber, String> {

        private static final String PHONE_PATTERN = "^\\+?[0-9]{10,15}$";

        @Override
        public boolean isValid(String value, ConstraintValidatorContext context) {
            if (value == null || value.trim().isEmpty()) {
                return false;
            }
            return value.matches(PHONE_PATTERN);
        }
    }

