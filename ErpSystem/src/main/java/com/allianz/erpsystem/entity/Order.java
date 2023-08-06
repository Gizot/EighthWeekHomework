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

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderObj> orderObjList = new ArrayList<>();

    boolean orderStatus;

    @OneToOne
    @JoinColumn(name = "invoice_id")
    private Bill bill;

}
