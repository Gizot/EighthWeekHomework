package com.allianz.erpsystem.entity;

import com.allianz.erpsystem.util.utildb.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@SuppressWarnings("ALL")
@Entity
@Table
@AttributeOverride(name = "uuid", column = @Column(name = "customer_uuid"))
@AttributeOverride(name = "id", column = @Column(name = "customer_id"))
@Data
public class Bill extends BaseEntity {
    @Column
    private List<String> nameList;
    @Column
    private int numberOfProduct;
    @Column
    private BigDecimal kdvPrice;
    @Column
    private BigDecimal normalPrice;
    @Column
    private BigDecimal kdvTotalPrice;
    @Column
    private BigDecimal normalTotalPrice;
}
