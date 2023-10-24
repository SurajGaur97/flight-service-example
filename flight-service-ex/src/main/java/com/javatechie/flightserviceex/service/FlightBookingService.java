package com.javatechie.flightserviceex.service;

import com.javatechie.flightserviceex.dto.FLightBookingAcknowledgement;
import com.javatechie.flightserviceex.dto.FlightBookingRequest;
import com.javatechie.flightserviceex.entity.PassengerInfo;
import com.javatechie.flightserviceex.entity.PaymentInfo;
import com.javatechie.flightserviceex.repository.PassengerInfoRepository;
import com.javatechie.flightserviceex.utils.PaymentUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class FlightBookingService {
	
	Logger logger = LoggerFactory.getLogger(FlightBookingRequest.class);
	
    @Autowired
    private PassengerInfoRepository passengerInfoRepository;
    
    @Autowired
    private PaymentUtils paymentUtils;

    @Transactional
    public FLightBookingAcknowledgement bookFlightTicket(FlightBookingRequest request)
    {
    	logger.info("Is Debug Enabled: " + logger.isDebugEnabled());
    	logger.info("Inside the class: FlightBookingService");
    	
    	PassengerInfo passengerInfo = request.getPassengerInfo();
    	PaymentInfo paymentInfo = request.getPaymentInfo();
        
        //Validate the amount of user
        paymentUtils.validateCreditLimit(paymentInfo.getAccountNo(), passengerInfo.getFare());

        paymentInfo.setAmount(passengerInfo.getFare());
        paymentInfo.setPassengerInfo(passengerInfo);
        
        passengerInfo.setPaymentInfo(paymentInfo);
        
        passengerInfoRepository.save(passengerInfo);

        return new FLightBookingAcknowledgement("Success!", passengerInfo.getFare(),
                UUID.randomUUID().toString().split("-")[0], passengerInfo);
    }
    
    @Transactional
    public FLightBookingAcknowledgement bookFlightTicket(PassengerInfo request)
    {
        //Validate the amount of user
        paymentUtils.validateCreditLimit(request.getPaymentInfo().getAccountNo(), request.getFare());

        request.getPaymentInfo().setAmount(request.getFare());
        
        passengerInfoRepository.save(request);

        return new FLightBookingAcknowledgement("Success!", request.getFare(),
                UUID.randomUUID().toString().split("-")[0], request);
    }
}
