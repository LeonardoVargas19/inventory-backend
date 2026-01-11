package org.leoromero.productservices.service.impl;

import lombok.RequiredArgsConstructor;
import org.leoromero.productservices.exceptions.DuplicateSkuException;
import org.leoromero.productservices.model.Product;
import org.leoromero.productservices.model.dto.InventoryResponse;
import org.leoromero.productservices.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductImp implements ProductService {
    private static final Logger log = LoggerFactory.getLogger(ProductImp.class);


    private final ProductRepository productRepository;

    @Override
    public Product findId(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no Encontrado"));

    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(Product product) {
        if (existSKU(product)) {
            log.error("EL SKU YA SE ENCUENTRA REGISTRADO{}", product.getSku());
            throw new DuplicateSkuException(product.getSku());
        }
        log.info("SE REGISTRO EXITOSAMENTE EL PRODUCTO{}", product);
        product.setIsActive(true);
        Product product1 = findId(product.getId());
        product.setPrice(product1.getPrice());
        return productRepository.save(product);
    }

    @Override
    public void deleteById(Long id) {
        Product product = findId(id);
        log.info("PRODUCTO ELIMINADO{} ... {}", product.getName(), product.getSku());
        productRepository.deleteById(id);
    }

    @Override
    public boolean existSKU(Product product) {
        return productRepository.existsBySku(product.getSku());
    }

    @Override
    public List<InventoryResponse> findBySkuIn(List<String> skus) {

        return productRepository.findBySkuIn(skus).stream()
                .map(product -> InventoryResponse.builder()
                        .sku(product.getSku())
                        .isInStock(product.getStock() > 0)
                        .prices(product.getPrice())
                        .build()
                ).collect(Collectors.toList());


    }
}
