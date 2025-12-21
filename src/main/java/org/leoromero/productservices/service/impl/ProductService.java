package org.leoromero.productservices.service.impl;

import org.leoromero.productservices.model.Product;

import java.util.List;

public interface ProductService {
    Product findId(Long Id);

    List<Product> getAllProducts();

    Product createProduct(Product product);

    void deleteById(Long id);

    boolean existSKU(Product product);


}
