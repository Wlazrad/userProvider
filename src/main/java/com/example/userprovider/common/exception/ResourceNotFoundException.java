package com.example.userprovider.common.exception;

import lombok.Getter;

@Getter
public class ResourceNotFoundException extends InternalRuntimeException {

    private final String resourceName;

    public ResourceNotFoundException(String resourceName, ExceptionMessages exceptionMessages) {
        super(exceptionMessages);
        this.resourceName = resourceName;
    }
}
