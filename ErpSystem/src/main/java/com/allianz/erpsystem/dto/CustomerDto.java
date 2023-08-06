package com.allianz.erpsystem.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class CustomerDto {
    private UUID uuid;
    private String name;
    private String surname;
    private int birthYear;
    private String email;
    private int cardNo;
    private String address;
    private List<OrderDto> orderDtoList = new ArrayList<>();

    public CustomerDto() {
        this.uuid = UUID.randomUUID();
    }
}
