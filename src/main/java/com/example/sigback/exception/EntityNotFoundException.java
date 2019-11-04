package com.example.sigback.exception;

/**
 * Author: brianfroschauer
 * Date: 26/10/2019
 */
public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException() {
        super("Entity not found");
    }
}
