package com.w2s.poc.dto.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;


@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse extends Exception {
    private static final long serialVersionUID = 1L;

    private Integer code;
    private String message;
    private Map<String, Object> data;
    private Instant time;

    @Override
    @JsonIgnore
    public StackTraceElement[] getStackTrace() {
        return super.getStackTrace();
    }

    public void addDataAttribute(String attributeName, Object attributeValue) {
        if(this.data == null){
            this.data = new HashMap<>();
        }
        this.data.put(attributeName, attributeValue);
    }


}
