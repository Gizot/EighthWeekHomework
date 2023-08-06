package com.allianz.erpsystem.repository;

import com.allianz.erpsystem.dto.OrderDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface Order extends JpaRepository <Order, Long> {
    @Modifying
    void deleteByUuid(UUID uuid);

    Optional<Order> findByUuid(UUID uuid);
}
