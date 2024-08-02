package com.RepoRequest.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


// branch for DTO
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RepoDtoOwner {
    private String login;
}
