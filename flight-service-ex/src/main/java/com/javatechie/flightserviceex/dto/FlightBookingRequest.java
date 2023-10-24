package com.javatechie.flightserviceex.dto;

import com.javatechie.flightserviceex.entity.PassengerInfo;
import com.javatechie.flightserviceex.entity.PaymentInfo;
import lombok.Data;

@Data
public class FlightBookingRequest {

    private PassengerInfo passengerInfo;
    private PaymentInfo paymentInfo;

}
