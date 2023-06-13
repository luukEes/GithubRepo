package com.RepoRequest.model;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RepoDto {
    private String name;
    private String login;
}
