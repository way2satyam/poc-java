package com.w2s.poc.converter;


import com.w2s.poc.utils.DateTime;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

import java.time.Instant;

public class StringToInstantConverter implements Converter<String, Instant> {
    private final Logger logger = LoggerFactory.getLogger(StringToInstantConverter.class);

    @Override
    public Instant convert(String source) {
        if (Strings.isBlank(source)) {
            return Instant.now();
        }
        return DateTime.convert(source);
    }
}
