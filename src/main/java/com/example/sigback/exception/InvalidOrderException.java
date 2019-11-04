package com.example.sigback.exception;

/**
 * Author: brianfroschauer
 * Date: 04/11/2019
 */
public class InvalidOrderException extends RuntimeException {

    public InvalidOrderException() {
        super("Invalid order");
    }
}
