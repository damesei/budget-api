package com.damesei.budgetapi.service;
import com.damesei.budgetapi.model.Transaction;
import com.damesei.budgetapi.repository.TransactionRepository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService{
    private final TransactionRepository repo;

    public TransactionService(TransactionRepository repo) {
        this.repo = repo;
    }

    public List<Transaction> getAll() {
        return repo.findAll();
    }

    public Transaction create(Transaction t) {
        return repo.save(t);
    }

    public Optional<Transaction> getById(String id) {
        return repo.findById(id);
    }

    public void deleteById(String id) {
        if (!repo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Transaction not found");
        }
        repo.deleteById(id);
    }

    public Transaction update(String id, Transaction updatedTransaction) {
    return repo.findById(id)
        .map(existing -> {
            if (updatedTransaction.getTransactionType() != null) {
                existing.setTransactionType(updatedTransaction.getTransactionType());
            }
            if (updatedTransaction.getCategory() != null) {
                existing.setCategory(updatedTransaction.getCategory());
            }
            if (updatedTransaction.getTransactionDate() != null) {
                existing.setTransactionDate(updatedTransaction.getTransactionDate());
            }
            if (updatedTransaction.getAmount() != null) {
                existing.setAmount(updatedTransaction.getAmount());
            }
            if (updatedTransaction.getNote() != null) {
                existing.setNote(updatedTransaction.getNote());
            }
            return repo.save(existing);
        })
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Transaction not found"));
}





}