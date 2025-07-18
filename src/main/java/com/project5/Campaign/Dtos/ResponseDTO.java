package com.project5.Campaign.Dtos;

import java.time.LocalDateTime;

public class ResponseDTO {
    private String msg;
    private String error;
    private String path;
    private LocalDateTime timestamp;

    public ResponseDTO(){}
    public ResponseDTO(String msg, String error, String path) {
        this.msg = msg;
        this.error = error;
        this.path = path;
        this.timestamp = LocalDateTime.now();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
