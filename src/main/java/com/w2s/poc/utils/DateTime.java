package com.w2s.poc.utils;

import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTime {

    private static final Logger logger = LoggerFactory.getLogger(DateTime.class);

    private static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm";

    public static String convert(Instant dateTime, @NonNull String pattern) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(dateTime, ZoneOffset.UTC);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        String formatDateTime = localDateTime.format(formatter);
        logger.debug("InstantToStringConverter Pattern : {} | Source : {} | Result {}",
                pattern, dateTime, formatDateTime);
        return formatDateTime;
    }

    public static String convert(Instant dateTime) {
        return convert(dateTime, DEFAULT_DATE_TIME_FORMAT);
    }

    public static Instant convert(String dateTime, @NonNull String pattern) {
        if (Strings.isBlank(dateTime)) {
            return null;
        }
        Instant formatDateTime = null;
        try {
            Date date = new SimpleDateFormat(pattern).parse(dateTime);
            formatDateTime = date.toInstant();
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.debug("InstantToStringConverter Pattern : {} | Source : {} | Result {}",
                pattern,
                dateTime,
                formatDateTime);
        return formatDateTime;
    }

    public static Instant convert(String dateTime) {
        String pattern;
        if (dateTime.matches("\\d{4}-\\d{2}-\\d{2}")) {
            pattern = "yyyy-MM-dd";
        } else if (dateTime.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}")) {
            pattern = "yyyy-MM-dd HH:mm:ss";
        } else {
            pattern = DEFAULT_DATE_TIME_FORMAT;
        }
        return convert(dateTime, pattern);
    }

    public static Instant convert(long epochMilli) {
        return Instant.ofEpochMilli(epochMilli);
    }
}
