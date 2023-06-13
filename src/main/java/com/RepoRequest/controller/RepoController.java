package com.RepoRequest.controller;

import com.RepoRequest.service.RepoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class RepoController {

    public  final RepoService repoService;


    // mapping for a specific URL
    @GetMapping("/getUser")
    public String getUser(){
        return repoService.getUser();
    }
}
