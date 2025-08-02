package io.github.mitohondriyaa.client.service;

import io.github.mitohondriyaa.client.exception.TokenNotAvailableException;
import io.github.mitohondriyaa.client.model.AccessToken;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccessTokenService {
    private final OAuth2AuthorizedClientManager authorizedClientManager;

    public AccessToken getAccessToken() {
        OAuth2AuthorizeRequest authorizeRequest = OAuth2AuthorizeRequest
            .withClientRegistrationId("security-client")
            .build();
        OAuth2AuthorizedClient authorizedClient = authorizedClientManager
            .authorize(authorizeRequest);

        if (authorizedClient == null) {
            throw new TokenNotAvailableException("No token available");
        }

        return new AccessToken(
            authorizedClient.getAccessToken().getTokenValue()
        );
    }
}