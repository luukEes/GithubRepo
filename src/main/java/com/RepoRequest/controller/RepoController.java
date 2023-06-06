package com.RepoRequest.service.controller;

import com.RepoRequest.model.RepoDto;
import com.RepoRequest.service.RepoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class RepoController {

    public  final RepoService repoService;

    @GetMapping("/getUser")
    public RepoDto getUser(){
        return repoService.getUser();
    }
}
