package com.RepoRequest.client.dataDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserDto {
    public UserDtoName name;
    public UserDtoLogin owner;
}
