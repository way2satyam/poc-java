package com.w2s.poc.converter;


import com.w2s.poc.utils.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class InstantToStringConverter implements Converter<Instant, String> {
    private final Logger logger = LoggerFactory.getLogger(InstantToStringConverter.class);

    @Override
    public String convert(Instant source) {
        return DateTime.convert(source);
    }
}
