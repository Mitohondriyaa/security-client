package io.github.mitohondriyaa.client.service;

import io.github.mitohondriyaa.client.client.KeycloakClient;
import io.github.mitohondriyaa.client.exception.TokenNotAvailableException;
import io.github.mitohondriyaa.client.model.AccessToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Service
public class AccessTokenService {
    private final KeycloakClient  keycloakClient;
    private final MultiValueMap<String, String> requestBody
        = new LinkedMultiValueMap<>();

    public AccessTokenService(
        KeycloakClient keycloakClient,
        @Value("${client-id}")
        String clientId,
        @Value("${client-secret}")
        String clientSecret,
        @Value("${username}")
        String username,
        @Value("${password}")
        String password
    ) {
        this.keycloakClient = keycloakClient;
        requestBody.add("grant_type", "password");
        requestBody.add("client_id", clientId);
        requestBody.add("client_secret", clientSecret);
        requestBody.add("username", username);
        requestBody.add("password", password);
    }

    public AccessToken getAccessToken() {
        AccessToken accessToken = keycloakClient.getAccessToken(requestBody);

        if (accessToken == null) {
            throw new TokenNotAvailableException("Token not available");
        }

        return accessToken;
    }
}