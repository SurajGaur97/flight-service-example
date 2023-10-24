package com.javatechie.flightserviceex.dto;

import com.javatechie.flightserviceex.entity.PassengerInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FLightBookingAcknowledgement {

    private String status;
    private Double totalFare;
    private String pnrNo;
    private PassengerInfo passengerInfo;

}
