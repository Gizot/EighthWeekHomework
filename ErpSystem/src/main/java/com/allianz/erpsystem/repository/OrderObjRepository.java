package com.allianz.erpsystem.repository;

import com.allianz.erpsystem.entity.OrderObj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrderObjRepository extends JpaRepository<OrderObj, Long> {
    @Modifying
    void deleteByUuid(UUID uuid);

    Optional<OrderObj> findByUuid(UUID uuid);
}
