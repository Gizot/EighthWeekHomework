package com.allianz.erpsystem.repository;

import com.allianz.erpsystem.dto.ProductDto;
import com.allianz.erpsystem.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Modifying
    List<Product> findAll();
    Product findAllByNameIgnoreCase(String name);

    void  deleteProductByUuid(UUID uuid);
    Optional<Product> findByUuid(UUID uuid);
}
