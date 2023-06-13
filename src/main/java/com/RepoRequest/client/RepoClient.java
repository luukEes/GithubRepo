package com.RepoRequest.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RepoClient {

    public static final String First_half_URI = "https://api.github.com/users/";
    public static final String Sec_half_URI = "/repos";
    private RestTemplate restTemplate = new RestTemplate();

    // Sting.class its type for the return
    // uriVariables its provided by restTemplate we can use to adding next parameter
    public String getUserRepo(String user) {
        return restTemplate.getForObject(First_half_URI + "{username}" + Sec_half_URI,
                String.class,user);
    }

   // private String callMethod(String url, Object...objects ) {
     //   return restTemplate.getForObject(First_half_URI + "{username}" + Sec_half_URI,
          //      String.class,objects);
    //}
}
