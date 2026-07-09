package com.kolorsmoothies.erp.constant;

public final class ApiMessages {

    private ApiMessages() {
    }

    // Success
    public static final String CREATED = "Record created successfully.";
    public static final String UPDATED = "Record updated successfully.";
    public static final String DELETED = "Record deleted successfully.";
    public static final String FETCHED = "Record fetched successfully.";

    // Errors
    public static final String NOT_FOUND = "Resource not found.";
    public static final String DUPLICATE = "Resource already exists.";
    public static final String INVALID_REQUEST = "Invalid request.";
    public static final String INTERNAL_SERVER_ERROR = "Something went wrong.";

}