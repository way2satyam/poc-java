package com.w2s.poc.dto.mapper;

import com.w2s.poc.dto.UserData;
import com.w2s.poc.model.User;

public class UserToUserData {

    public static UserData convert(User user) {
        if (user != null) {
            return UserData.builder()
                    .id(user.getId())
                    .name(user.getName())
                    .username(user.getUsername())
                    .userNumber(user.getUserNumber())
                    .email(user.getEmail())
                    .mobile(user.getMobile())
                    .coverIcon(user.getCoverIcon())
                    .coverImage(user.getCoverImage())
                    .createdTime(InstantToStringMapper.convert(user.getCreatedTime()))
                    .modifiedTime(InstantToStringMapper.convert(user.getModifiedTime()))
                    .build();
        }
        return null;
    }

}
