package com.allianz.erpsystem.repository;

import com.allianz.erpsystem.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BillRepository extends JpaRepository <Bill, Long> {
    @Modifying
    void deleteByUuid(UUID uuid);

    Optional<Bill> findByUuid(UUID uuid);
}
