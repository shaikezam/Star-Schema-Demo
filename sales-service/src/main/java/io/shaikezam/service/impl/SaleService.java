package io.shaikezam.service.impl;

import io.shaikezam.exception.NotFoundException;
import io.shaikezam.model.SaleDTO;
import io.shaikezam.repository.ISaleRepository;
import io.shaikezam.service.ISaleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SaleService implements ISaleService {

    private final ISaleRepository saleRepository;

    @Override
    public List<SaleDTO> getAllSalesByUserId(Long userId) {
        log.info("Fetching all sales for user ID: {}", userId);
        return saleRepository.findAllSalesByUserId(userId);
    }

    @Override
    public SaleDTO getSaleById(Long id) {
        log.info("Fetching sale with ID: {}", id);
        return saleRepository.findSaleById(id)
                .orElseThrow(() -> new NotFoundException("Sale not found with ID: " + id));
    }

    @Override
    public SaleDTO createSale(SaleDTO saleDTO) {
        log.info("Creating new sale for user ID: {}", saleDTO.getUserId());
        return saleRepository.createSale(saleDTO);
    }

    @Override
    public SaleDTO updateSale(Long id, SaleDTO saleDTO) {
        log.info("Updating sale with ID: {}", id);
        return saleRepository.updateSale(id, saleDTO)
                .orElseThrow(() -> new NotFoundException("Sale not found with ID: " + id));
    }

    @Override
    public void deleteSale(Long id) {
        log.info("Deleting sale with ID: {}", id);
        if (!saleRepository.deleteSale(id)) {
            throw new NotFoundException("Sale not found with ID: " + id);
        }
    }
}
