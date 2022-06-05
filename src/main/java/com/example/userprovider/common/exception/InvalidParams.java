package com.example.userprovider.common.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InvalidParams {
    private String businessIdName;
    private String businessIdValue;
    private String path;
    private String name;
    private String reason;
}
