package com.task.syncapplication.dto.response.common;

public interface ResponseCode {
    //HTTP Status 200
    String SUCCESS = "SU";
    //HTTP Status 204
    String NO_CONTENT = "NC";
    //HTTP Status 400
    String VALIDATION_FAILED = "VF";
    //HTTP Status 500
    String DATABASE_ERROR = "DBE";
}
