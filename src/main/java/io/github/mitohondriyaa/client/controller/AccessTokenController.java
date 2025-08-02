package io.github.mitohondriyaa.client.controller;

import io.github.mitohondriyaa.client.model.AccessToken;
import io.github.mitohondriyaa.client.service.AccessTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/access-token")
@RequiredArgsConstructor
public class AccessTokenController {
    private final AccessTokenService accessTokenService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public AccessToken getAccessToken() {
        return accessTokenService.getAccessToken();
    }
}