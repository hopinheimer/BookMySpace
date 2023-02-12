package com.ohspaces.bookmyspace.repository;

import com.ohspaces.bookmyspace.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {


}
