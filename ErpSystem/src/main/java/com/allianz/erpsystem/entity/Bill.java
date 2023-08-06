package com.allianz.erpsystem.entity;

import com.allianz.erpsystem.util.utildb.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@AttributeOverride(name = "uuid", column = @Column(name = "bill_uuid"))
@AttributeOverride(name = "id", column = @Column(name = "bill_id"))
@Data
public class Bill extends BaseEntity {

    @Column
    private int billNo;
    @Column
    private double totalPriceWithVAT;
    @Column
    private double totalPriceWithoutVAT;
    @Column
    private double totalVATAmount;
    @OneToOne(mappedBy = "invoice")
    private Order order;
}
