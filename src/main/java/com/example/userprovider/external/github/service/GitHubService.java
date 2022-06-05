package com.example.userprovider.external.github.service;

import com.example.userprovider.external.github.model.response.GitHubResponse;

public interface GitHubService {
    GitHubResponse getUserData(String login);
}
