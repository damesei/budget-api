package com.damesei.budgetapi.exception;

public class InvalidExpenseException extends RuntimeException{
    public InvalidExpenseException(String message) {
        super(message);
    } 
}
