package com.w2s.poc.utils;

import java.util.UUID;

public class KeyGen {

    public static String generateUUIDKey(String prefix) {
        if(prefix == null || prefix.length() < 1) {
            throw new IllegalArgumentException("prefix can't be null or empty");
        }
        return prefix + "-" + UUID.randomUUID().toString().replace("-", "");
    }
}
