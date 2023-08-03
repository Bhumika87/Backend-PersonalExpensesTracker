package com.finance.Personalfinance.Exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public String HandelResourceNotFoundException(ResourceNotFoundException mes)
    {
       return mes.getMessage();
    }
}
