package com.Employee.HrRecruitmentSystem.ExceptionHandler;


public class ResourceAlreadyExistsException extends RuntimeException {
    public ResourceAlreadyExistsException(String message) {
        super(message);
    }
}
