package com.example.userprovider.common.exception;

public class InternalRuntimeException extends RuntimeException {
    private final ExceptionMessages messages;

    public InternalRuntimeException(ExceptionMessages messages) {
        super(messages.getTitle());
        this.messages = messages;
    }
}
