package com.RepoRequest.service;

import com.RepoRequest.client.RepoClient;
import com.RepoRequest.model.RepoDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RepoService {

     private final RepoClient repoClient= new RepoClient();
     // calling method getUserRepo(String user) we need to provide a parameter "user". Method return his repository
     public RepoDto[] getUser(){
    return repoClient.getUserRepo("luukees");
    }
}