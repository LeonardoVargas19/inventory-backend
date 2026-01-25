package org.leoromero.productservices.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InventoryResponse {
    @Schema(description = "Codigo unico de producto",example = "IPHONE-15-PRO")
    private String sku;
    @Schema(description = "Identificador sobre si el producto esta disponible",example = "True")
    private Boolean isInStock;
    @Schema(description = "Precio del producto",example = "1299.00")
    private BigDecimal prices;

}
