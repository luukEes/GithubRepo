package com.RepoRequest.controller;

import com.RepoRequest.model.RepoDto;
import com.RepoRequest.service.RepoService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@AllArgsConstructor
@Getter
@Setter
public class RepoController  {

    private final RepoService repoService;

    @GetMapping("/getUser")
    public ResponseEntity<?> getUser(@RequestParam String username,
                                     @RequestHeader(value = HttpHeaders.CONTENT_TYPE, defaultValue = "application/json") String contentTypeHeader) {


        // try catch block for checking headers
        if (!"application/json".equals(contentTypeHeader)) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", HttpStatus.NOT_ACCEPTABLE.value());
            errorResponse.put("message", "Content-Type header must be 'application/json'");

            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_ACCEPTABLE);
        }

        try {
            RepoDto[] repos = repoService.getUser(username);
            HttpHeaders headers = new HttpHeaders();
            headers.set(HttpHeaders.CONTENT_TYPE, "application/json");
            return ResponseEntity.ok().headers(headers).body(repos);
        } catch (UserNotFoundException ex) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", HttpStatus.NOT_FOUND.value());
            errorResponse.put("message", ex.getMessage());

            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
    }

    // Exception returning 404 code if guy does not exist
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleUserNotFoundException(UserNotFoundException ex) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("status", HttpStatus.NOT_FOUND.value());
        errorResponse.put("message", ex.getMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}