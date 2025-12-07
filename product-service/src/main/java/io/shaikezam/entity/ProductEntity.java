package io.shaikezam.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;

    @NotNull
    @Size(min = 1)
    @Column(name = "product_name", nullable = false, columnDefinition = "TEXT")
    private String productName;

    @NotNull
    @Size(min = 1)
    @Column(name = "category", nullable = false, columnDefinition = "TEXT")
    private String category;

    @NotNull
    @Size(min = 1)
    @Column(name = "sub_category", nullable = false, columnDefinition = "TEXT")
    private String subCategory;

    @Column(name = "brand", columnDefinition = "TEXT")
    private String brand;

    @NotNull
    @Column(name = "price", nullable = false, columnDefinition = "DECIMAL(10, 2)")  // Changed to DECIMAL
    private Double price;

    @NotNull
    @Size(min = 1)
    @Column(name = "type", nullable = false, columnDefinition = "TEXT")
    private String type;

    @DecimalMin("0.00")
    @DecimalMax("5.00")
    @Column(name = "rating", columnDefinition = "DECIMAL(3, 2)")  // Changed to DECIMAL
    private Double rating;

    @NotNull
    @Size(min = 1)
    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;
}
