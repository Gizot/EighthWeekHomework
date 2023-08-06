package com.allianz.erpsystem.service;

import com.allianz.erpsystem.entity.Customer;
import com.allianz.erpsystem.repository.CostomerRepository;
import com.allianz.erpsystem.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService {
    @Autowired
    CostomerRepository customerRepository;
    @Autowired
    OrderRepository orderRepository;

    // Yeni bir müşteri oluşturmak için kullanılan metod.
    public Customer createCustomer(String name, String surname) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setSurname(surname);

        customerRepository.save(customer);
        return customer;
    }
    // Müşterilerin tamamını listelemek için kullanılan metod.
    public List<Customer> getCustomerList() {
        return customerRepository.findAll();
    }
    // İsimle müşteri aramak için kullanılan metod.
    public Customer getCustomerByName(String name) {
        return customerRepository.findAllByNameIgnoreCase(name);
    }
    // UUID ile müşteri aramak için kullanılan metod.
    public Customer getCustomerByUUID(UUID uuid) {
        Optional<Customer> customerEntityOptional = customerRepository.findByUuid(uuid);

        if (customerEntityOptional.isPresent()) {
            return customerEntityOptional.get();
        } else {
            return null;
        }
    }
    // UUID ile müşteriyi silmek için kullanılan metod.
    @Transactional
    public Boolean deleteCustomerByUUID(UUID uuid) {
        Customer customerEntity = getCustomerByUUID(uuid);

        if (customerEntity != null) {
            customerRepository.deleteCustomerEntitiesByUuid(uuid);
            return true;
        } else {
            return false;
        }
    }
    // UUID ile müşteriyi güncellemek için kullanılan metod.
    public Customer updateCustomerByUUID(UUID uuid, Customer newCustomerEntity) {
        Customer customerEntity = getCustomerByUUID(uuid);

        if (customerEntity != null) {
            customerEntity.setName(newCustomerEntity.getName());
            customerEntity.setSurname(newCustomerEntity.getSurname());

            customerRepository.save(customerEntity);
            return customerEntity;
        } else {
            return null;
        }
    }
}
