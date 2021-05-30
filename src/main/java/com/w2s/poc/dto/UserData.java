package com.w2s.poc.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

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
    private String coverIcon;  // aka covericon
    private String coverImage;
    private Instant createdTime;
    private Instant modifiedTime;

}
