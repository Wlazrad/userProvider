package com.example.userprovider.common.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class ControllerExceptionHandler {

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public InternalApiError handleResourceNotFoundException(ResourceNotFoundException ex) {
        ExceptionMessages messages = ExceptionMessages.SERVICE_NOT_FOUND;
        return createInternalApiError(messages);
    }

    private InternalApiError createInternalApiError(ExceptionMessages messages) {
        return InternalApiError.builder()
                .title(messages.getTitle())
                .build();
    }

}
