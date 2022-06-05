package com.example.userprovider.service.impl;

import com.example.userprovider.common.exception.ExceptionMessages;
import com.example.userprovider.common.exception.InternalRuntimeException;
import lombok.Getter;

@Getter
public class DivideByZeroException extends InternalRuntimeException {
    private final String resourceName;

    public DivideByZeroException(String resourceName, ExceptionMessages exceptionMessages) {
        super(exceptionMessages);
        this.resourceName = resourceName;
    }
}