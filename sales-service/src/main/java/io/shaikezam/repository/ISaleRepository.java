package io.shaikezam.repository;

import io.shaikezam.model.SaleDTO;

import java.util.List;
import java.util.Optional;

public interface ISaleRepository {
    List<SaleDTO> findAllSalesByUserId(Long userId);
    Optional<SaleDTO> findSaleById(Long id);
    SaleDTO createSale(SaleDTO saleDTO);
    Optional<SaleDTO> updateSale(Long id, SaleDTO saleDTO);
    boolean deleteSale(Long id);
}
