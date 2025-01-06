package io.shaikezam.service;

import io.shaikezam.model.ProductDTO;

import java.util.Optional;

public interface IProductService {
    Optional<ProductDTO> getProduct(Integer productId);
}
