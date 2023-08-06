package com.allianz.erpsystem.entity;

import com.allianz.erpsystem.util.utildb.BaseEntity;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;
@Entity
@Table
@AttributeOverride(name= "uuid", column = @Column(name="orderItem_uuid"))
@Data
public class Product extends BaseEntity {
    @Column
    private UUID uuid;
    @Column
    private String name;
    @Column
    private String BrandEnum;

    @Column
    private double price;
    @Column
    private  boolean hasDiscount;
    @Column
    private QuantityTypeEnum quantityTypeEnum;
    @Column
    private int criticalStock;
    @Column
    private CategoryEnum categoryEnum;



}
