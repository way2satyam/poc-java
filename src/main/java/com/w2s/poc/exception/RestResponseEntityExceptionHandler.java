package com.w2s.poc.exception;

import com.w2s.poc.dto.common.CommonResponse;
import com.w2s.poc.dto.common.ErrorResponse;
import com.w2s.poc.service.UserServiceImpl;
import com.w2s.poc.utils.StackTraceUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    Logger logger = LoggerFactory.getLogger(RestResponseEntityExceptionHandler.class);

    @ExceptionHandler(ErrorResponse.class)
    public ResponseEntity<?> handleException(ErrorResponse error) {
        logger.error(error.toString(), this.getClass());
        ResponseEntity<ErrorResponse> responseEntity = new ResponseEntity<ErrorResponse>(error, HttpStatus.BAD_REQUEST);
        return responseEntity;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception error) {
        logger.error(error.toString(), error, this.getClass());
        ErrorResponse errorResponse = new ErrorResponse(9000, error.getClass().getName());
        errorResponse.addDataAttribute("cause", error.getMessage());
        errorResponse.addDataAttribute("stackTrace", StackTraceUtils.stackTraceToString(error));
        ResponseEntity<CommonResponse> responseEntity = new ResponseEntity<CommonResponse>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        return responseEntity;
    }



}