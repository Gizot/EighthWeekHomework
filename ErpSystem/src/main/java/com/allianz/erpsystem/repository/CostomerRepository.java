package com.allianz.erpsystem.repository;

import com.allianz.erpsystem.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CostomerRepository extends JpaRepository<Customer, Long > {

    @Modifying
    void deleteByUuid(UUID uuid);

    Optional<Customer> findByUuid(UUID uuid);

    List<Customer> findAllByNameStartingWith(String key);

    List<Customer> findAllByNameStartingWithOrSurnameStartingWith(String name, String surname);
}
