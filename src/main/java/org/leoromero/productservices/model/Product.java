package org.leoromero.productservices.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Table(name = "products")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Schema(description = "Codigo unico de producto",example = "IPHONE-15-PRO")
    private String sku;
    @Schema(description = "Nombre del producto",example = "Iphone15Pro")
    private String name;
    @Schema(description = "Precio del producto",example = "1299.00")
    private BigDecimal price;
    @Schema(description = "Indicador sobre numero de existencia del producto",example = "1")
    private Long stock;
    @Schema(description = "Identificador sobre si el producto esta disponible",example = "True")
    private Boolean isActive;



}

