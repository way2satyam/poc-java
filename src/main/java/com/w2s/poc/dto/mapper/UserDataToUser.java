package com.w2s.poc.dto.mapper;

import com.w2s.poc.dto.UserData;
import com.w2s.poc.model.User;
import org.apache.logging.log4j.util.Strings;

public class UserDataToUser {

    public static User convert(UserData source, User target) {
        if (source != null) {
            if (target == null) {
                target = convert(source);
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
                    target.setCreatedTime(StringToInstantMapper.convert(source.getCreatedTime()));
                }
                target.setName(source.getName());
                target.setEmail(source.getEmail());
                target.setMobile(source.getMobile());
                target.setCoverIcon(source.getCoverIcon());
                target.setCoverImage(source.getCoverImage());
                target.setModifiedTime(StringToInstantMapper.convert(source.getModifiedTime()));
            }
        }
        return target;

    }

    public static User convert(UserData source) {
        User target = new User();
        return convert(source, target);
    }
}
