package com.javatechie.flightserviceex.exception;

public class InsufficientAmountException extends RuntimeException {
    public InsufficientAmountException(String msg) {
        super(msg);
    }
}
