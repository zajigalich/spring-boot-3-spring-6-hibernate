package com.udemy.spring_boot_rest_crud.entity;

public class StudentErrorResponse {
    private int code;
    private String message;
    private long timestamp;

    public StudentErrorResponse() {
    }

    public StudentErrorResponse(int code, String message, long timestamp) {
        this.code = code;
        this.message = message;
        this.timestamp = timestamp;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "StudentErrorResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
