package com.RepoRequest.service;

import com.RepoRequest.client.RepoClient;
import com.RepoRequest.controller.UserNotFoundException;
import com.RepoRequest.model.RepoDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RepoService {

    private final RepoClient repoClient;

    // Calling method getUserRepo(String user) we need to provide a parameter "user". Method returns his repository
    public RepoDto[] getUser(String username) {
        RepoDto[] repos = repoClient.getUserRepo(username);
        if (repos == null || repos.length == 0) {
            throw new UserNotFoundException("User not found: " + username);
        }
        return repos;
     }
}