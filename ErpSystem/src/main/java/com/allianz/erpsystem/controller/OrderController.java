package com.allianz.erpsystem.controller;

import com.allianz.erpsystem.entity.Order;
import com.allianz.erpsystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    // Siparişleri listeleyen HTTP GET isteği işleme metodu.
    @GetMapping("order")
    public ResponseEntity<List<Order>> getOrderList() {
        return new ResponseEntity<>(orderService.getOrderList(), HttpStatus.OK);
    }

    // Yeni bir sipariş oluşturmak için HTTP POST isteği işleme metodu.
    @PostMapping("order/{customer_id}")
    public ResponseEntity<Order> createOrder(@RequestBody Order order, @PathVariable Long customer_id) throws Exception {
        Order order1 = orderService.createOrder(order, customer_id);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    // Siparişe ürün eklemek için HTTP PUT isteği işleme metodu.
    @PutMapping("order/{order_id}/product/{product_id}")
    public Order addProductToOrder(@PathVariable Long order_id, @PathVariable Long product_id) {
        return orderService.addProductToOrder(order_id, product_id);
    }

    // Siparişi UUID ile silmek için HTTP DELETE isteği işleme metodu.
    @DeleteMapping("order/{uuid}")
    public ResponseEntity<Boolean> deleteOrder(@PathVariable UUID uuid) {
        Boolean isDeleted = orderService.deleteOrderByUUID(uuid);
        if (isDeleted) {
            return new ResponseEntity<>(Boolean.TRUE, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(Boolean.FALSE, HttpStatus.NOT_FOUND);
        }
    }

    // Siparişi UUID ile güncellemek için HTTP PUT isteği işleme metodu.
    // customer_id ve product_id kullanılır, çünkü onetomany ve manytomany ilişkileri kurulmuştur.
    @PutMapping("order/{uuid}/{customer_id}/{product_id}")
    public ResponseEntity<Order> updateOrderByUUID(@PathVariable UUID uuid, @RequestBody Order newOrderEntity,
                                                   @PathVariable Long customer_id, @PathVariable Long product_id) {
        Order order = orderService.updateOrderByUUID(uuid, newOrderEntity, customer_id, product_id);
        if (order != null) {
            return new ResponseEntity<>(order, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
