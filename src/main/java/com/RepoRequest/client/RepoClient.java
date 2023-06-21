package com.RepoRequest.client;
import com.RepoRequest.model.RepoDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class RepoClient {

    private static final RestTemplate restTemplate = new RestTemplate();
    public static final String Url_For_Specified_User = "https://api.github.com/users/{user}/repos";
    RepoDto[] repoDtosBody = new RepoDto[0];

    // By uriVariables provided by restTemplate we can use to adding next parameter
    public RepoDto[] getUserRepo(String user) {
        ResponseEntity<RepoDto[]> response =
                restTemplate.getForEntity(Url_For_Specified_User,
                        RepoDto[].class, user);
        repoDtosBody = response.getBody();
        return repoDtosBody;
    }
}