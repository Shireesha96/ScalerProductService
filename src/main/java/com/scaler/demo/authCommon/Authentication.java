package com.scaler.demo.authCommon;

import com.scaler.demo.dto.UserDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Authentication {
    private RestTemplate restTemplate;

    public Authentication(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public UserDTO validateToken(String token) {
        UserDTO userDTO = restTemplate.getForObject("http://localhost:4141/users/validate/" + token, UserDTO.class);
        return userDTO;
    }
}
