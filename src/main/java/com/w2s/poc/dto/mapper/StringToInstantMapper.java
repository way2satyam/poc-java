package com.w2s.poc.dto.mapper;

import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class StringToInstantMapper {
    private static final Logger logger = LoggerFactory.getLogger(StringToInstantMapper.class);

    public static Instant convert(String dateTime) {
        if (Strings.isBlank(dateTime)) {
            return Instant.now();
        }
        Instant formatDateTime = null;
        try {
            String pattern;
            if (dateTime.matches("\\d{4}-\\d{2}-\\d{2}")) {
                pattern = "yyyy-MM-dd";
            } else if (dateTime.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}")) {
                pattern = "yyyy-MM-dd HH:mm:ss";
            } else {
                pattern = "yyyy-MM-dd HH:mm";
            }
            Date date = new SimpleDateFormat(pattern).parse(dateTime);
            formatDateTime = date.toInstant();
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.debug("InstantToStringConverter for {} is {}",
                dateTime,
                formatDateTime);
        return formatDateTime;
    }
}
