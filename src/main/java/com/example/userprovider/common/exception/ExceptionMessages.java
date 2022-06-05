package com.example.userprovider.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ExceptionMessages {

    MISSING_SERVLET_REQUEST_PARAMETER("missing.servlet_request_parameter.title", null, "missing.servlet_request_parameter.name", null),
    SERVICE_NOT_FOUND("service.not_found.github_user", null, "service.not_found.name", "service.not_found.reason"),
    DIVIDE_BY_ZERO("divide_by_zero", null, null, null);

    private final String title;
    private final String path;
    private final String name;
    private final String reason;

}
