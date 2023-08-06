package com.allianz.erpsystem.entity;

import com.allianz.erpsystem.util.utildb.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@AttributeOverride(name = "uuid", column = @Column(name = "customer_uuid"))
@AttributeOverride(name = "id", column = @Column(name = "customer_id"))
@Data
public class Customer extends BaseEntity {
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private int birthYear;
    @Column
    private String email;
    @Column
    private int cardNo;
    @Column
    private String address;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orderList = new ArrayList<>();

}
