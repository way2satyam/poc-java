package com.w2s.poc.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class UserData implements Serializable {
    private String id;
    private String name;
    private String username;
    private String userNumber;
    private String email;
    private String mobile;
    private String coverIcon;
    private String coverImage;
    private String createdTime;
    private String modifiedTime;

}
