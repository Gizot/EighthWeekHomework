package com.allianz.erpsystem.service;

import com.allianz.erpsystem.entity.Bill;
import com.allianz.erpsystem.entity.Order;
import com.allianz.erpsystem.entity.OrderState;
import com.allianz.erpsystem.entity.Product;
import com.allianz.erpsystem.repository.BillRepository;
import com.allianz.erpsystem.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class BillService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    BillRepository billRepository;


    public Bill createBill(Bill bill, Long order_id) {
        Bill bill1 = bill;

        addOrderToBill(bill1, order_id);

        billRepository.save(bill1);
        return bill;
    }

    public List<Bill> getInvoiceList() {
        return billRepository.findAll();
    }

    public void addOrderToBill(Bill bill, Long order_id) {
        BigDecimal kdvTotalPrice = BigDecimal.ZERO;
        BigDecimal normalTotalPrice = BigDecimal.ZERO;
        Order order = orderRepository.findById(order_id).get();
        order.setOrderStatusEnum(OrderState.APPROVED);

        bill.setNumberOfProduct(order.getProductList().size());
        for (Product product : order.getProductList()) {
            if (bill.getNameList() != null) {
                bill.getNameList().add(product.getName());

                if (product.getHasVAT()) {
                    bill.setKdvPrice(BigDecimal.valueOf(product.getPrice()).multiply(BigDecimal.valueOf(1.2)));
                    bill.setNormalPrice(BigDecimal.valueOf(product.getPrice()));
                    normalTotalPrice.add(BigDecimal.valueOf(product.getPrice()));
                    kdvTotalPrice.add(BigDecimal.valueOf(product.getPrice()).multiply(BigDecimal.valueOf(1.2)))
                            .add(normalTotalPrice);

                } else {
                    bill.setNormalPrice(BigDecimal.valueOf(product.getPrice()));
                    normalTotalPrice.add(BigDecimal.valueOf(product.getPrice()));
                }

            } else {
                List<String> nameList = new ArrayList<>();
                nameList.add(product.getName());
                bill.setNameList(nameList);

                if (product.getHasVAT()) {
                    bill.setKdvPrice(BigDecimal.valueOf(product.getPrice()).multiply(BigDecimal.valueOf(1.2)));
                    bill.setNormalPrice(BigDecimal.valueOf(product.getPrice()));
                    bill.setNormalTotalPrice(normalTotalPrice.add(BigDecimal.valueOf(product.getPrice())));
                    bill.setKdvTotalPrice(kdvTotalPrice.add(BigDecimal.valueOf(product.getPrice()).multiply(BigDecimal
                                    .valueOf(1.2))).
                            add(normalTotalPrice));

                } else {
                    bill.setNormalPrice(BigDecimal.valueOf(product.getPrice()));
                    normalTotalPrice.add(BigDecimal.valueOf(product.getPrice()));
                }

            }

        }
    }

}
