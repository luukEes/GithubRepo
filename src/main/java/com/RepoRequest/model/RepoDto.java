package com.RepoRequest.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

/*
 creating new fields here -> getting more data in json
 */
public class RepoDto {
    private String name;
    private String full_name;
    private RepoDtoOwner owner;
    private boolean fork = false;
    private String pushed_at;
}
