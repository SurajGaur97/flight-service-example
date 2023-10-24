package com.javatechie.flightserviceex.controller;

import com.javatechie.flightserviceex.dto.FLightBookingAcknowledgement;
import com.javatechie.flightserviceex.dto.FlightBookingRequest;
import com.javatechie.flightserviceex.entity.PassengerInfo;
import com.javatechie.flightserviceex.service.FlightBookingService;
import com.javatechie.flightserviceex.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/flightService")
public class FlightBookingController {

    @Autowired
    private FlightBookingService service;

    @PostMapping("/bookFlight")
    public ResponseEntity<?> bookFlight(@RequestBody FlightBookingRequest request)
    {
        ApiResponse<FLightBookingAcknowledgement> apiRes;
        try {
            apiRes = new ApiResponse<>();
            FLightBookingAcknowledgement acknowledgement = service.bookFlightTicket(request);

            apiRes.setResult(acknowledgement);
            apiRes.setMessage("Flight Booking Successful!");
            apiRes.setStatus(HttpStatus.OK.value());

            return ResponseEntity.ok(apiRes);
        }
        catch (Exception ex) {
        	ex.printStackTrace();
            apiRes = new ApiResponse<>();
            apiRes.setMessage("Flight Booking Unsuccessful!");
            apiRes.setStatus(HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.badRequest().body(apiRes);
        }
    }
    
    @PostMapping("/bookFlightEntity")
    public ResponseEntity<?> bookFlight(@RequestBody PassengerInfo request)
    {
        ApiResponse<FLightBookingAcknowledgement> apiRes;
        try {
            apiRes = new ApiResponse<>();
            FLightBookingAcknowledgement acknowledgement = service.bookFlightTicket(request);

            apiRes.setResult(acknowledgement);
            apiRes.setMessage("Flight Booking Successful!");
            apiRes.setStatus(HttpStatus.OK.value());

            return ResponseEntity.ok(apiRes);
        }
        catch (Exception ex) {
        	ex.printStackTrace();
            apiRes = new ApiResponse<>();
            apiRes.setMessage("Flight Booking Unsuccessful!");
            apiRes.setStatus(HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.badRequest().body(apiRes);
        }
    }
}
