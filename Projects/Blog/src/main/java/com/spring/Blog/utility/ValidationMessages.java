package com.spring.Blog.utility;


public enum ValidationMessages {
    SUCCESS("Success"),
    NAME_REQUIRED("Username is required"),
    NAME_IS_NOT_VALID("Username must contain only alphanumeric characters and/or underscore"),
    PASSWORD_IS_NOT_VALID("Password must have at least one lowercase letter, one uppercase letter, one digit and one special character"),

    EMAIL_ALREADY_EXISTS("Email already exists"),
    EMAIL_IS_NOT_VALID("Email is invalid");
    private final String message;

    ValidationMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
