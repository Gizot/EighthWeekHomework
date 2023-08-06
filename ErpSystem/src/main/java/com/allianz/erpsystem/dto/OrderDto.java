package com.allianz.erpsystem.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.UUID;

@Getter
@Setter
public class OrderDto {
    private UUID uuid;
    boolean orderStatus;
    private CustomerDto customer;
    private ArrayList<ProductDto> productDtoList;

    public OrderDto() {
        this.uuid = UUID.randomUUID();
    }


}
