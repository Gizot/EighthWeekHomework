package com.allianz.erpsystem.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.UUID;

public class Product {
    private UUID uuid;
    private String name;
    private BigDecimal price;
    boolean hasDiscount;
    private int stockAmount;
    private ArrayList <Order> orderList;
    private CategoryEnum categoryEnum;
    private QuantityTypeEnum quantityTypeEnum;
}
