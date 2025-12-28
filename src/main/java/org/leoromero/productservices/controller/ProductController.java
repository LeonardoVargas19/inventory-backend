package org.leoromero.productservices.controller;

import lombok.RequiredArgsConstructor;
import org.leoromero.productservices.model.Product;
import org.leoromero.productservices.service.impl.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    private static final Logger log = LoggerFactory.getLogger(ProductController.class);
    private final ProductService productService;

    @GetMapping()
    public ResponseEntity<List<Product>> getAllProduct() {
        log.info("EXECUTE GET ALL");
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id) {
        log.info("FIND PRODUCT BY ID");
        return new ResponseEntity<>(productService.findId(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        log.info("CREATE NEW PRODUCT");
        return new ResponseEntity<>(productService.createProduct(product), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable Long id) {
        log.info("DELETE PRODUCT");
        productService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
