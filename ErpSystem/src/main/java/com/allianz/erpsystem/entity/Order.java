package com.allianz.erpsystem.entity;

import com.allianz.erpsystem.util.utildb.BaseEntity;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@AttributeOverride(name = "uuid", column = @Column(name = "order_uuid"))
@AttributeOverride(name = "id", column = @Column(name = "order_id"))
@Data
public class Order extends BaseEntity {

}
