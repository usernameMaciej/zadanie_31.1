package com.example.weatherapiexercise.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
public class ErrorControllerAdvice {

    @ExceptionHandler(HttpClientErrorException.class)
    public String handleHttpClientErrorException() {
        return "httpError";
    }
}
