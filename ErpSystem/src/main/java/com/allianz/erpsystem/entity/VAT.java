package com.allianz.erpsystem.entity;

import com.allianz.erpsystem.util.utildb.BaseEntity;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@AttributeOverride(name= "uuid", column = @Column(name="vat_uuid"))
@Data
public class VAT extends BaseEntity {

    @Column
    private int min = 1;
    @Column
    private int normalProduct = 8/100;
    @Column
    private int luxuryProduct = 18/100;}
