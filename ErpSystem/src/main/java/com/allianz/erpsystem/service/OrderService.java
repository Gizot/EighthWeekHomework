package com.allianz.erpsystem.service;

import com.allianz.erpsystem.entity.Customer;
import com.allianz.erpsystem.entity.Order;
import com.allianz.erpsystem.entity.OrderState;
import com.allianz.erpsystem.entity.Product;
import com.allianz.erpsystem.repository.CostomerRepository;
import com.allianz.erpsystem.repository.OrderRepository;
import com.allianz.erpsystem.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CostomerRepository customerRepository;

    // Yeni bir sipariş oluşturmak için kullanılan metod.
    public Order createOrder(Order newOrder, Long customer_id) {
        Customer customer = customerRepository.findById(customer_id).orElse(null);
        Order order = newOrder;
        order.setOrderState(OrderState.STAND_BY);
        order.setCustomer(customer);
        orderRepository.save(newOrder);
        customer.getOrderList().add(order);
        return order;
    }
    // Sipariş listesini almak için kullanılan metod.
    public List<Order> getOrderList(){
        return orderRepository.findAll();
    }
    // Siparişe ürün eklemek için kullanılan metod.
    public Order addProductToOrder(Long order_id,  Long product_id){
        List<Product> productList = null;
        Order order = orderRepository.findById(order_id).get();
        Product productEntity = productRepository.findById(product_id).get();

        productList = order.getProductList();

        if(productEntity.getStock()>0){
            productList.add(productEntity);

            productEntity.setStock(productEntity.getStock()-1);
            order.setProductList(productList);
        }else {
            return null;
        }
        return orderRepository.save(order);

    }
    // UUID ile sipariş aramak için kullanılan metod.
    public Order getOrderByUUID(UUID uuid){
        Optional<Order> orderEntityOptional = orderRepository.findByUuid(uuid);

        if(orderEntityOptional.isPresent()){
            return  orderEntityOptional.get();
        }else {
            return null;
        }
    }
    // UUID ile siparişi silmek için kullanılan metod.
    @Transactional
    public  Boolean deleteOrderByUUID(UUID uuid){
        Order orderEntity = getOrderByUUID(uuid);

        if(orderEntity!=null){
            orderRepository.deleteOrderEntitiesByUuid(uuid);
            return true;
        }else {
            return  false;
        }
    }
    // UUID ile siparişi güncellemek için kullanılan metod.
    public  Order updateOrderByUUID(UUID uuid, Order newOrderEntity, long customer_id, long product_id){
        Order orderEntity = getOrderByUUID(uuid);
        Customer customer = customerRepository.findById(customer_id).get();
        Product product = productRepository.findById(product_id).get();

        if(orderEntity!=null){
            orderEntity.setOrderStatusEnum(orderEntity.getOrderStatusEnum());
            orderEntity.setCustomer(customer);
            if(product.getStock()>0){
                orderEntity.getProductList().add(product);
                product.setStock(product.getStock()-1);
            }
            orderRepository.save(orderEntity);
            return orderEntity;
        }else{
            return null;
        }
    }




}