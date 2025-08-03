package io.github.mitohondriyaa.client.service;

import io.github.mitohondriyaa.client.client.KeycloakClient;
import io.github.mitohondriyaa.client.model.AccessToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Service
public class AccessTokenService {
    private final KeycloakClient  keycloakClient;
    @Value("${client-id}")
    private String clientId;
    @Value("${client-secret}")
    private String clientSecret;
    @Value("${username}")
    private String username;
    @Value("${password}")
    private String password;
    private final MultiValueMap<String, String> requestBody
        = new LinkedMultiValueMap<>();

    public AccessTokenService(KeycloakClient keycloakClient) {
        this.keycloakClient = keycloakClient;
        requestBody.add("grant_type", "password");
        requestBody.add("client_id", clientId);
        requestBody.add("client_secret", clientSecret);
        requestBody.add("username", username);
        requestBody.add("password", password);
    }

    public AccessToken getAccessToken() {
        return keycloakClient.getAccessToken(requestBody);
    }
}