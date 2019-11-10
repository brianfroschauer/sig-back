package com.example.sigback.exception;

public class NoMoreSpaceException extends RuntimeException {

    public NoMoreSpaceException() {
        super("No more space");
    }
}
