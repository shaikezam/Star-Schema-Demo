package io.shaikezam.controller;

import io.shaikezam.model.SaleDTO;
import io.shaikezam.service.ISaleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sales")
public class SaleController {

    private final ISaleService saleService;

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<SaleDTO>> getSalesByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(saleService.getAllSalesByUserId(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleDTO> getSale(@PathVariable Long id) {
        return ResponseEntity.ok(saleService.getSaleById(id));
    }

    @PostMapping
    public ResponseEntity<SaleDTO> createSale(@Valid @RequestBody SaleDTO saleDTO) {
        return new ResponseEntity<>(saleService.createSale(saleDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SaleDTO> updateSale(
            @PathVariable Long id,
            @Valid @RequestBody SaleDTO saleDTO) {
        return ResponseEntity.ok(saleService.updateSale(id, saleDTO));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSale(@PathVariable Long id) {
        saleService.deleteSale(id);
    }
}
