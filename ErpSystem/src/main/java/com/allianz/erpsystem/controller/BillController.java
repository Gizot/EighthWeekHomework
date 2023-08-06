package com.allianz.erpsystem.controller;

import com.allianz.erpsystem.entity.Bill;
import com.allianz.erpsystem.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BillController {
    @Autowired
    BillService billService;

    // Faturaların listesini döndüren HTTP GET isteği işleme metodu.

    @GetMapping("bill")
    public ResponseEntity<List<Bill>> getInvoiceList() {

        return new ResponseEntity<>(billService.getInvoiceList(), HttpStatus.OK);
    }


    // Yeni bir fatura oluşturmak için HTTP POST isteği işleme metodu.
    @PostMapping("bill/{order_id}")
    public ResponseEntity<Bill> createOrder(
            @RequestBody Bill bill, @PathVariable Long order_id) throws Exception {

        Bill bill1 = billService.createBill(bill, order_id);


        return new ResponseEntity<>(bill, HttpStatus.CREATED);
    }
}
