package com.allianz.erpsystem.entity;

import com.allianz.erpsystem.util.utildb.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@AttributeOverride(name = "uuid", column = @Column(name = "order_uuid"))
@AttributeOverride(name = "id", column = @Column(name = "order_id"))
@Data
public class Order extends BaseEntity {

    @Column
    private OrderState orderStatusEnum;

    //orderlist in CustomerEntity
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    //orderlist in ProductEntity
    @ManyToMany
    @JoinTable(
            name = "order_product",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> productList;

    public void setOrderState(OrderState standBy) {
    }
}
