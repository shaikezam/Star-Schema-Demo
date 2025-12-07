package io.shaikezam.service;

import io.shaikezam.model.SaleDTO;

import java.util.List;

public interface ISaleService {
    List<SaleDTO> getAllSalesByUserId(Long userId);
    SaleDTO getSaleById(Long id);
    SaleDTO createSale(SaleDTO saleDTO);
    SaleDTO updateSale(Long id, SaleDTO saleDTO);
    void deleteSale(Long id);
}
