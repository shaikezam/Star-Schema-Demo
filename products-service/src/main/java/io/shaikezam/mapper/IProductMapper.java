package io.shaikezam.mapper;

import io.shaikezam.entity.ProductEntity;
import io.shaikezam.model.ProductDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface IProductMapper {

    ProductDTO toProductDTO(ProductEntity productEntity);

    ProductEntity toProductEntity(ProductDTO productDTO);

    List<ProductDTO> toProductsDTOs(List<ProductEntity> entities);
}
