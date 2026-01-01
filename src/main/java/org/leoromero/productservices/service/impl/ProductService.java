package org.leoromero.productservices.service.impl;

import org.leoromero.productservices.model.Product;
import org.leoromero.productservices.model.dto.InventoryResponse;

import java.util.List;

public interface ProductService {
    Product findId(Long Id);

    List<Product> getAllProducts();

    Product createProduct(Product product);

    void deleteById(Long id);

    boolean existSKU(Product product);

    List<InventoryResponse> findBySkuIn(List<String> skus);

}
