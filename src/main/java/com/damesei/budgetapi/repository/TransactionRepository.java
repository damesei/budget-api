package com.damesei.budgetapi.repository;

import com.damesei.budgetapi.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,String>
{
    
}
