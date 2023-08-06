package com.allianz.erpsystem.dto;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class BillDto {

    private List<String> nameList;

    private int numberOfProduct;
    private BigDecimal vatPrice;
    private BigDecimal normalPrice;
    private BigDecimal vatTotalPrice;
    private BigDecimal normalTotalPrice;
}
