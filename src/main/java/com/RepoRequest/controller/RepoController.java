package com.RepoRequest.controller;

import com.RepoRequest.model.RepoDto;
import com.RepoRequest.service.RepoService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@AllArgsConstructor
@Getter
@Setter
public class RepoController {

    public final RepoService repoService;

    // mapping for a specific URL
    // UserNotFound exception is a claas responsible for catching null in username ( username not found in DB)
    @GetMapping("/getUser")
    public RepoDto[] getUser(@RequestParam String username) throws UserNotFound {
        return repoService.getUser(username);
    }
}
