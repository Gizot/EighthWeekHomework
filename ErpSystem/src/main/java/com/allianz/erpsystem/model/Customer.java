package com.allianz.erpsystem.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String surname;
    private int birthYear;
    private String email;
    private int cardNo;
    private String address;
    private List<Order> orderList = new ArrayList<>();
}
