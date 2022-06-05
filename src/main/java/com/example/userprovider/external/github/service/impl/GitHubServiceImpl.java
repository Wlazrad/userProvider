package com.example.userprovider.external.github.service.impl;

import com.example.userprovider.common.exception.ExceptionMessages;
import com.example.userprovider.common.exception.ResourceNotFoundException;
import com.example.userprovider.external.github.model.response.GitHubResponse;
import com.example.userprovider.external.github.service.GitHubService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class GitHubServiceImpl implements GitHubService {

    private static final String GITHUB_USER = "githubUser";
    @Value("https://api.github.com/users/")
    private String githubUrl;

    @Override
    public GitHubResponse getUserData(String login) {

        WebClient webClient = buildWebClient(githubUrl);

        GitHubResponse gitHubResponse = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(login)
                        .build())
                .retrieve()
                .onStatus(HttpStatus.BAD_REQUEST::equals,
                        error -> Mono.error(new ResourceNotFoundException(GITHUB_USER, ExceptionMessages.MISSING_SERVLET_REQUEST_PARAMETER)))
                .onStatus(HttpStatus.NOT_FOUND::equals,
                        error -> Mono.error(new ResourceNotFoundException(GITHUB_USER, ExceptionMessages.SERVICE_NOT_FOUND)))
                .bodyToMono(GitHubResponse.class)
                .block();

        log.info(String.format("[GitHubService] Received data for user login: %s", login));
        return gitHubResponse;
    }

    private WebClient buildWebClient(String url) {
        return WebClient.builder()
                .baseUrl(url)
                .build();
    }
}
