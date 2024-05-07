package com.task.syncapplication.dto.response.common;

public interface ResponseMessage {
    //HTTP Status 200
    String SUCCESS = "Success.";
    //HTTP Status 204
    String NO_CONTENT = "No Content.";
    //HTTP Status 400
    String VALIDATION_FAILED = "Validation failed.";
    //HTTP Status 500
    String DATABASE_ERROR = "Database error.";
}
