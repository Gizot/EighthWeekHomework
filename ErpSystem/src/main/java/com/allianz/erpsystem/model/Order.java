package com.allianz.erpsystem.model;

import java.util.ArrayList;
import java.util.UUID;

public class Order {
    private UUID uuid;
    boolean orderStatus;
    private Customer customer;
    private ArrayList<Product> productList;

    public Order() {
        this.uuid = UUID.randomUUID();
    }


}
