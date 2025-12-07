package io.shaikezam.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.shaikezam.model.ProductDTO;
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
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProductApiClient {

    @Value("${product.service.url:http://product-service:8080}")
    private String baseUrl;

    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    @Cacheable(value = "products", key = "#productId", unless = "#result == null")
    public ProductDTO getProductById(Long productId) {
        if (productId == null) {
            throw new IllegalArgumentException("Product ID cannot be null");
        }
        log.info("Get product: {}", productId);
        String url = String.format("%s/api/products/%d", baseUrl, productId);
        return sendRequest(url, new TypeReference<ProductDTO>() {});
    }

    @SneakyThrows
    private <T> T sendRequest(String url, TypeReference<T> responseType) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() >= 200 && response.statusCode() < 300) {
                return objectMapper.readValue(response.body(), responseType);
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