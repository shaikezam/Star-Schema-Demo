package io.shaikezam.model;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * Represents a sale transaction with multiple products.
 * @param id The unique identifier of the sale
 * @param userId The ID of the user making the purchase
 * @param products A map of product IDs to quantities (must not be empty)
 * @param totalPrice The total price of the sale (must be positive or zero)
 * @param saleDate The date and time when the sale occurred (must not be in the future)
 * @param status The status of the sale (e.g., COMPLETED, CANCELLED, RETURNED)
 */
public record SaleDTO(
        Long id,
        @NotNull(message = "User ID is required") Long userId,
        @NotEmpty(message = "At least one product is required") Map<@Positive Long, @Positive Integer> products,
        @PositiveOrZero(message = "Total price must be positive or zero") BigDecimal totalPrice,
        @PastOrPresent(message = "Sale date cannot be in the future") LocalDateTime saleDate,
        @NotBlank(message = "Status is required") String status
) {
    public SaleDTO {
        if (saleDate == null) {
            saleDate = LocalDateTime.now();
        }
    }
}