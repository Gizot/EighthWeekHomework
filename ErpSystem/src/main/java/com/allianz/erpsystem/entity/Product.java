package com.allianz.erpsystem.entity;

import com.allianz.erpsystem.dto.CategoryEnum;
import com.allianz.erpsystem.util.utildb.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table
@AttributeOverride(name = "uuid", column = @Column(name = "product_uuid"))
@AttributeOverride(name = "id", column = @Column(name = "product_id"))
@Data
public class Product extends BaseEntity {

    @Column
    private UUID uuid;
    @Column
    private String name;
    @Column
    private int stock;
    @Column
    Boolean hasVAT;
    @Column
    private CategoryEnum categoryEnum;
    @Column
    private double price;
    @OneToOne(mappedBy = "product")
    private OrderObj orderItem;
}
