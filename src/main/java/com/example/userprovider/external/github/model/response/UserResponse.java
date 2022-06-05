package com.example.userprovider.external.github.model.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Value
@Builder(toBuilder = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    Long id;
    String login;
    String name;
    String type;
    String avatarUrl;
    LocalDateTime createdAt;
    String calculations;
}
