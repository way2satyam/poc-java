package com.w2s.poc.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("users")
@Builder
public class User {

    @Id
    private String id;
    private String name;
    private String username;
    private String userNumber;
    private String password;
    private String email;
    private String mobile;
    private String coverIcon;  // aka profilePic
    private String coverImage;
    private boolean locked;
    private boolean enabled;
    private boolean expired;
    private List<String> authorities = new ArrayList<>();
    private Instant createdTime;
    private Instant modifiedTime;

}
