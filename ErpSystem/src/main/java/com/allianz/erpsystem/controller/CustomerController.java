package com.allianz.erpsystem.controller;

import com.allianz.erpsystem.dto.CustomerDto;
import com.allianz.erpsystem.entity.Customer;
import com.allianz.erpsystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    //in order to list all customers.
    @GetMapping("customer")
    public ResponseEntity<List<Customer>> getCustomerList() {

        return new ResponseEntity<>(customerService.getCustomerList(), HttpStatus.OK);
    }

    //get customer oby name
    @GetMapping("customer/{name}")
    public ResponseEntity<Customer> getCustomer(@PathVariable String name) {

        return new ResponseEntity<>(customerService.getCustomerByName(name), HttpStatus.OK);
    }


    //save customer to db.
    @PostMapping("customer")
    public ResponseEntity<Customer> createCustomer(@RequestBody CustomerDto customerDto) throws Exception {

        Customer customer1 = customerService.createCustomer(customerDto.getName(),customerDto.getSurname());


        return new ResponseEntity<>(customer1, HttpStatus.CREATED);
    }

    @DeleteMapping("customer/{uuid}")
    public ResponseEntity<Boolean> deleteCustomer(@PathVariable UUID uuid) {

        Boolean isDeleted = customerService.deleteCustomerByUUID(uuid);
        if(isDeleted){
            return new ResponseEntity<>(Boolean.TRUE, HttpStatus.NOT_FOUND);

        }else {
            return new ResponseEntity<>(Boolean.FALSE, HttpStatus.NOT_FOUND);

        }
    }

    //update
    @PutMapping("customer/{uuid}")
    public ResponseEntity<Customer> updateCustomerByUUID(@PathVariable UUID uuid, @RequestBody Customer newCustomerEntity){

        Customer customerEntity = customerService.updateCustomerByUUID(uuid, newCustomerEntity);
        if(customerEntity!=null){
            return new ResponseEntity<>(customerEntity, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


}
