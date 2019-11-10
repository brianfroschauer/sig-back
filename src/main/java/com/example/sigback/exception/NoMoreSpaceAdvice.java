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
public class NoMoreSpaceAdvice {

    @ResponseBody
    @ExceptionHandler(NoMoreSpaceException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorInfo handle(HttpServletRequest req, Exception ex) {
        return new ErrorInfo(HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                ex.getMessage(),
                req.getRequestURI());
    }
}
