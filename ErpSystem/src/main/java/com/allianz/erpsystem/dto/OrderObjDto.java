package com.allianz.erpsystem.dto;

import com.allianz.erpsystem.entity.Order;
import com.allianz.erpsystem.entity.Product;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

public class OrderObjDto {
    private Order order;

    private Product product;

    private int quantity;

    private double priceForOrder;
}
