package io.github.mitohondriyaa.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AccessToken(@JsonProperty("access_token") String accessToken) {}