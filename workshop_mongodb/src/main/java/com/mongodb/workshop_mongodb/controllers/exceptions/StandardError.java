package com.mongodb.workshop_mongodb.controllers.exceptions;

import java.io.Serializable;
import java.util.Date;

public class StandardError implements Serializable {

    private Integer status;
    private String message;
    private Date timeStamp;
    private String path;
    private String error;

    public StandardError() {
    }

    public StandardError(Integer status, String message, Date timeStamp, String path, String error) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
        this.path = path;
        this.error = error;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
