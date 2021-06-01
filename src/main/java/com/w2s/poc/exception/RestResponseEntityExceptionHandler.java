package com.w2s.poc.exception;

import com.w2s.poc.dto.common.ErrorResponse;
import com.w2s.poc.utils.StackTraceUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(RestResponseEntityExceptionHandler.class);

    @ExceptionHandler(ErrorResponse.class)
    public ResponseEntity<?> handleException(ErrorResponse error) {
        logger.error(error.toString(), this.getClass());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception error) {
        logger.error(error.toString(), error, this.getClass());
        ErrorResponse errorResponse = ErrorResponse.builder()
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(error.getClass().getName())
                .time(Instant.now())
                .build();
        errorResponse.addDataAttribute("cause", error.getMessage());
        errorResponse.addDataAttribute("stackTrace", StackTraceUtils.stackTraceToString(error));
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }



}