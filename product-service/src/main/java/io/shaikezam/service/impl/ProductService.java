package io.shaikezam.service.impl;

import io.shaikezam.entity.ProductEntity;
import io.shaikezam.mapper.IProductMapper;
import io.shaikezam.model.ProductDTO;
import io.shaikezam.repository.ProductRepository;
import io.shaikezam.service.IProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Component
public class ProductService implements IProductService {

    private final ProductRepository repository;
    private final IProductMapper mapper;

    @Override
    public Optional<ProductDTO> getProduct(Integer productId) {
        Objects.requireNonNull(productId);

        log.info("will get product id {}", productId);
        Optional<ProductEntity> entity = repository.findById(productId);
        return entity.map(mapper::toProductDTO);
    }
}
