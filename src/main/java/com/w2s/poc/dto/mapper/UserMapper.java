package com.w2s.poc.dto.mapper;

import com.w2s.poc.dto.UserData;
import com.w2s.poc.model.User;
import com.w2s.poc.utils.DateTime;
import org.apache.logging.log4j.util.Strings;

public class UserMapper {

    public static User convertUserDataToUser(UserData source, User target) {
        if (source != null) {
            if (target == null) {
                target = convertUserDataToUser(source);
            } else {
                if (!Strings.isBlank(source.getId())) {
                    target.setId(source.getId());
                }
                if (!Strings.isBlank(source.getUsername())) {
                    target.setUsername(source.getUsername());
                }
                if (!Strings.isBlank(source.getUserNumber())) {
                    target.setUserNumber(source.getUserNumber());
                }
                if (source.getCreatedTime() != null) {
                    target.setCreatedTime(DateTime.convert(source.getCreatedTime()));
                }
                target.setName(source.getName());
                target.setEmail(source.getEmail());
                target.setMobile(source.getMobile());
                target.setCoverIcon(source.getCoverIcon());
                target.setCoverImage(source.getCoverImage());
                target.setModifiedTime(DateTime.convert(source.getModifiedTime()));
            }
        }
        return target;

    }

    public static User convertUserDataToUser(UserData source) {
        User target = new User();
        return convertUserDataToUser(source, target);
    }

    public static UserData convertUserToUserData(User user) {
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
                    .createdTime(DateTime.convert(user.getCreatedTime()))
                    .modifiedTime(DateTime.convert(user.getModifiedTime()))
                    .build();
        }
        return null;
    }

}
