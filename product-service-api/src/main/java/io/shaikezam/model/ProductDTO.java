package io.shaikezam.model;

import lombok.Builder;

@Builder
public record ProductDTO(
        Integer productId,
        String productName,
        String category,
        String subCategory,
        String brand,
        Double price,
        String type,
        Double rating,
        String description
) {
}