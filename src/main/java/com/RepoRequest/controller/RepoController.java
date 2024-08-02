package com.RepoRequest.controller;

import com.RepoRequest.model.RepoDto;
import com.RepoRequest.service.RepoService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

@RestController
@AllArgsConstructor
@Getter
@Setter
public class RepoController {

    public final RepoService repoService;

    @GetMapping("/getUser")
    public RepoDto[] getUser(@RequestParam String username) {
        return repoService.getUser(username);
    }
    // Exception handler
    // Using hasMap to send messages into Postman/API testing soft. We can fully control the type of information sent to the user.
    // here handler for 404 http  
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleUserNotFoundException(UserNotFoundException ex) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("status", HttpStatus.NOT_FOUND.value());
        errorResponse.put("message", ex.getMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
