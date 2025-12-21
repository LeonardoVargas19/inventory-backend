package org.leoromero.productservices.repository;

import org.leoromero.productservices.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findAll ();

    void delete(Long id);

    boolean existsBySku(String sku);


}
