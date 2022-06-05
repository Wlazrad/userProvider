package com.example.userprovider.facade;

import com.example.userprovider.external.github.model.response.GitHubResponse;
import com.example.userprovider.external.github.model.response.UserResponse;
import com.example.userprovider.external.github.service.GitHubService;
import com.example.userprovider.service.CalculationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFacade {
    private final CalculationService calculationService;
    private final GitHubService gitHubService;

    public UserResponse getUserResponse(String login) {
        GitHubResponse userData = gitHubService.getUserData(login);
        return UserResponse.builder()
                .id(userData.getId())
                .login(userData.getLogin())
                .name(userData.getName())
                .type(userData.getType())
                .avatarUrl(userData.getAvatarUrl())
                .createdAt(userData.getCreatedAt())
                .calculations(String.valueOf(calculationService
                        .calculate(Double.parseDouble(userData.getFollowers()), Double.parseDouble(userData.getPublicRepos()))))
                .build();

    }
}
