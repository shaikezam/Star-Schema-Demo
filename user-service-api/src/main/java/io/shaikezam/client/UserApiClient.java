package io.shaikezam.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.shaikezam.model.UserDTO;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserApiClient {

    @Value("${user.service.url:http://user-service:8080}")
    private String baseUrl;

    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    @Cacheable(value = "users", key = "#userId", unless = "#result == null")
    public Optional<UserDTO> getUserById(Integer userId) {
        if (userId == null) {
            throw new IllegalArgumentException("User ID cannot be null");
        }
        log.info("Fetching user with ID: {}", userId);
        String url = String.format("%s/api/users/%d", baseUrl, userId);
        return sendRequest(url, new TypeReference<UserDTO>() {});
    }

    @SneakyThrows
    private <T> Optional<T> sendRequest(String url, TypeReference<T> responseType) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Accept", "application/json")
                .GET()
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                return Optional.ofNullable(objectMapper.readValue(response.body(), responseType));
            } else if (response.statusCode() == 404) {
                log.warn("User not found for URL: {}", url);
                return Optional.empty();
            } else {
                String error = String.format("Request failed with status %d: %s", response.statusCode(), response.body());
                log.error("Failed to process request for URL: {}", url, new RuntimeException(error));
                throw new RuntimeException(error);
            }
        } catch (Exception e) {
            log.error("Error occurred while calling URL: {}", url, e);
            throw e;
        }
    }
}