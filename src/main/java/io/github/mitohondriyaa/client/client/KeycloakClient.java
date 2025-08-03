package io.github.mitohondriyaa.client.client;

import io.github.mitohondriyaa.client.model.AccessToken;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.PostExchange;

public interface KeycloakClient {
    @PostExchange(contentType = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    AccessToken getAccessToken(@RequestBody MultiValueMap<String, String> body);
}