package io.github.mitohondriyaa.client.config;

import io.github.mitohondriyaa.client.client.KeycloakClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class RestClientConfig {
    @Value("${keycloak-token-url}")
    private String keycloakTokenUrl;

    @Bean
    public KeycloakClient keycloakClient() {
        RestClient restClient = RestClient.builder()
            .baseUrl(keycloakTokenUrl)
            .build();
        RestClientAdapter restClientAdapter = RestClientAdapter.create(restClient);
        HttpServiceProxyFactory httpServiceProxyFactory =
            HttpServiceProxyFactory.builderFor(restClientAdapter).build();
        return httpServiceProxyFactory.createClient(KeycloakClient.class);
    }
}