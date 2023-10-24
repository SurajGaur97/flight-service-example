package com.javatechie.flightserviceex.utils;

import com.javatechie.flightserviceex.exception.InsufficientAmountException;
import com.javatechie.flightserviceex.repository.PassengerInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PaymentUtils {
	
    @Autowired
    private PassengerInfoRepository infoRepository;

    public boolean validateCreditLimit(String accNo, Double paidAmount) {
        Map<String, Object> accAmount = infoRepository.getBalance(accNo);
        if(paidAmount > (double)accAmount.get("amount")) {
            throw new InsufficientAmountException("Insufficient fund");
        }
        else {
            return true;
        }
    }
}
