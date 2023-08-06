package com.allianz.erpsystem.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.UUID;

@Getter
@Setter
public class ProductDto {
    private UUID uuid;
    private String name;
    private BigDecimal price;
    boolean hasDiscount;
    private int stockAmount;
    private ArrayList <OrderDto> orderDtoList;
    private CategoryEnum categoryEnum;
    private QuantityTypeEnum quantityTypeEnum;

    public ProductDto(){this.uuid = UUID.randomUUID();}
}
