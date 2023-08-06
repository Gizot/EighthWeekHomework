package com.allianz.erpsystem.repository;

import com.allianz.erpsystem.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository <Order, Long> {
    List<Order> findAll();
    void  deleteOrderEntitiesByUuid(UUID uuid);
    Optional<Order> findByUuid(UUID uuid);
}
