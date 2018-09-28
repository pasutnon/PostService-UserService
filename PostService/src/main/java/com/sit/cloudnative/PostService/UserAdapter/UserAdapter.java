package com.sit.cloudnative.PostService.UserAdapter;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserAdapter {
    public User getUserDetail(long userId) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/users/" + userId;
        User user = restTemplate.getForObject(url, User.class);
        return user;
    }
}