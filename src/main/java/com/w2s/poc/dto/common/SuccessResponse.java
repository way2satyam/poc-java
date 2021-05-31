package com.w2s.poc.dto.common;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SuccessResponse implements CommonResponse {

    private int code;
    private String message;
    private Map<String, Object> data;

    public SuccessResponse() {
    }

    public SuccessResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public Map<String, ?> getData() {
        return this.data;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void setData(Map<String, ?> data) {
        this.data = (Map<String, Object>) data;
    }

    @Override
    public void addDataAttribute(String attributeName, Object attributeValue) {
        if (this.data == null) {
            this.data = new HashMap<String, Object>();
        }
        this.data.put(attributeName, attributeValue);
    }

    @Override
    public String toString() {
        return "SuccessResponse [code=" + code + ", message=" + message + ", data=" + data + "]";
    }
}
