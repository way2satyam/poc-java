package com.w2s.poc.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
@Document("users")
public class User implements Serializable {

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
    private boolean enabled = true;
    private boolean expired;
    private List<String> authorities = new ArrayList<>();
    private Instant createdTime;
    private Instant modifiedTime;

}
