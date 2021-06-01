package com.w2s.poc.dto.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class InstantToStringMapper {
    private static final Logger logger = LoggerFactory.getLogger(StringToInstantMapper.class);

    public static String convert(Instant dateTime) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(dateTime, ZoneOffset.UTC);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formatDateTime = localDateTime.format(formatter);
        logger.debug("InstantToStringConverter for {} is {}", dateTime, formatDateTime);
        return formatDateTime;
    }
}
