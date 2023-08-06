package com.allianz.erpsystem.controller;
import com.allianz.erpsystem.entity.Product;
import com.allianz.erpsystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;



    //in order to list all products.
    @GetMapping("product")
    public ResponseEntity<List<Product>> getProductList() {

        return new ResponseEntity<>(productService.getProductList(), HttpStatus.OK);
    }

    @GetMapping("product/{name}")
    public ResponseEntity<Product> getProduct(@PathVariable String name) {

        return new ResponseEntity<>(productService.getProductByName(name), HttpStatus.OK);
    }


    //save product to db.
    @PostMapping("product")
    public ResponseEntity<Product> createCustomer(@RequestBody Product product) throws Exception {

        Product product1 = productService.createProduct(product);


        return new ResponseEntity<>(product1, HttpStatus.CREATED);
    }

    @DeleteMapping("product/{uuid}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable UUID uuid) {

        Boolean isDeleted = productService.deleteProductByUUID(uuid);
        if(isDeleted){
            return new ResponseEntity<>(Boolean.TRUE, HttpStatus.NOT_FOUND);

        }else {
            return new ResponseEntity<>(Boolean.FALSE, HttpStatus.NOT_FOUND);

        }
    }

    //update
    @PutMapping("product/{uuid}")
    public ResponseEntity<Product> updateProductByUUID(@PathVariable UUID uuid, @RequestBody Product newProductEntity){

        Product productEntity = productService.updateProductByUUID(uuid, newProductEntity);
        if(productEntity!=null){
            return new ResponseEntity<>(productEntity, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}