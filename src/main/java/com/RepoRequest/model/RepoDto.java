package com.RepoRequest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor


 // creating new fields here -> getting more data in json
 // Data transfer object class to specify what type we wanne get

public class RepoDto {
    private String name;
    private RepoDtoOwner owner;
    private boolean fork = false;
    private String pushed_at;
}
