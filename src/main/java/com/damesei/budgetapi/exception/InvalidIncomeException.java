package com.damesei.budgetapi.exception;

public class InvalidIncomeException extends RuntimeException {
    public InvalidIncomeException(String message) {
        super(message);
    }
}
