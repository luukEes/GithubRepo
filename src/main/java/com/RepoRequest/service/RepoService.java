package com.RepoRequest.service;

import com.RepoRequest.client.RepoClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class RepoService {

     private final RepoClient repoClient= new RepoClient();

     // calling method getUserRepo(String user) we need to provide a parameter "user". Method return his repository
    public String getUser(){
        return repoClient.getUserRepo("luukEes");
    }
}
