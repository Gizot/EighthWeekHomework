package com.allianz.erpsystem.service;


import com.allianz.erpsystem.entity.Product;
import com.allianz.erpsystem.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    //prodcuctEntity requested By requestController in controller
    public Product createProduct(Product product) {
        productRepository.save(product);
        return product;
    }

    //finds all products in database
    public List<Product> getProductList() {
        return productRepository.findAll();
    }

    public Product getProductByName(String name) {
        return productRepository.findAllByNameIgnoreCase(name);
    }

    //will be used for delete
    public Product getProductByUUID(UUID uuid) {
        Optional<Product> productEntityOptional = productRepository.findByUuid(uuid);

        if (productEntityOptional.isPresent()) {
            return productEntityOptional.get();
        } else {
            return null;
        }
    }

    @Transactional
    public Boolean deleteProductByUUID(UUID uuid) {
        Product product = getProductByUUID(uuid);

        if (product != null) {
            productRepository.deleteProductByUuid(uuid);
            return true;
        } else {
            return false;
        }
    }

    public Product updateProductByUUID(UUID uuid, Product product1) {
        Product product = getProductByUUID(uuid);

        if (product != null) {
            product.setName(product1.getName());
            product.setPrice(product1.getPrice());
            product.setStock(product1.getStock());
            product.setHasVAT(product1.getHasVAT());

            productRepository.save(product);
            return product;
        } else {
            return null;

        }
    }

}
