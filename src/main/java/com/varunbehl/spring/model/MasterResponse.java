package com.varunbehl.spring.model;

public class MasterResponse {
    private String message;
    private boolean status;
    private Object responseData;


    public MasterResponse(String message, boolean status, Object responseData) {
        this.message = message;
        this.status = status;
        this.responseData = responseData;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Object getResponseData() {
        return responseData;
    }

    public void setResponseData(Object responseData) {
        this.responseData = responseData;
    }
}
