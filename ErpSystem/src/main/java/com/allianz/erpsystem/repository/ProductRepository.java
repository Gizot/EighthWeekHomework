package com.allianz.erpsystem.repository;

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
    void deleteByUuid(UUID uuid);

    Optional<Product> findByUuid(UUID uuid);

    List<Product> findAllByNameStartingWith(String key);
}
