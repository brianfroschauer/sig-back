package com.example.sigback.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * Author: brianfroschauer
 * Date: 04/11/2019
 */
@ControllerAdvice
public class InvalidOrderAdvice {

    @ResponseBody
    @ExceptionHandler(InvalidOrderException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorInfo employeeNotFoundHandler(HttpServletRequest req, Exception ex) {
        return new ErrorInfo(HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                ex.getMessage(),
                req.getRequestURI());
    }
}
