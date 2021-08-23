package com.thanachai.API.Bill;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BillRepository extends JpaRepository<DataBill, Long> {
   // @Query("SELECT s FROM bill s WHERE s.name = ?1")
    Optional<DataBill> findBillByName(String name);
}

