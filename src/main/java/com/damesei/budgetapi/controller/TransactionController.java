package com.damesei.budgetapi.controller;

import com.damesei.budgetapi.model.Transaction;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import com.damesei.budgetapi.service.TransactionService;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController{
    private final TransactionService service;

    public TransactionController(TransactionService service){
        this.service = service;
    }

    @GetMapping
    public List<Transaction> listTransactions(){
        return service.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Transaction createTransaction(@RequestBody Transaction t) {
        return service.create(t);
    }

    @GetMapping("/{id}")
    public Transaction geTransaction(@PathVariable String id) {
        return service.getById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Transaction not found"));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204 No Content
    public void deleteTransaction(@PathVariable String id) {
        service.deleteById(id);
    }

    @PutMapping("/{id}")
    public Transaction updateTransaction(@PathVariable String id, @RequestBody Transaction transaction) {
        return service.update(id, transaction);
}

}