package com.w2s.poc.dto.common;

import java.util.Map;

public interface CommonResponse {

    public int getCode();

    public void setCode(int code);

    public String getMessage();

    public void setMessage(String message);

    public Map<String, ?> getData();

    public void setData(Map<String, ?> data);

    public void addDataAttribute(String attributeName, Object attributeValue);

}
