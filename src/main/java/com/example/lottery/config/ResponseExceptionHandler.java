package com.example.lottery.config;

import com.example.lottery.controller.response.Response;
import com.example.lottery.error.DuplicateException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({ DuplicateException.class })
    public ResponseEntity<Response> handleAccessDeniedException(Exception ex, WebRequest request) {
        Response response = Response.builder()
                .code(1)
                .error(ex.getMessage())
                .build();
        return new ResponseEntity(response, new HttpHeaders(), HttpStatus.OK);
    }
}
