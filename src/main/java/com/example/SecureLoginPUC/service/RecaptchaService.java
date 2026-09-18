package com.example.SecureLoginPUC.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class RecaptchaService {

    @Value("${google.recaptcha.secret-key}")
    private String secretKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public boolean isValid(String token) {
        if (token == null || token.isBlank()) {
            return false;
        }

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("secret", secretKey);
        body.add("response", token);

        try {
            Map<?, ?> response = restTemplate.postForObject(
                    "https://www.google.com/recaptcha/api/siteverify",
                    body,
                    Map.class);

            return response != null && Boolean.TRUE.equals(response.get("success"));
        } catch (Exception e) {
            return false;
        }
    }
}
