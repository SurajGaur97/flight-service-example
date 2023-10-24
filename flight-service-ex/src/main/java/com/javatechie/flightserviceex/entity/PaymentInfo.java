package com.javatechie.flightserviceex.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Getter
@Setter
@Entity
@Table(name = "PAYMENT_INFO")
public class PaymentInfo {

//  @GeneratedValue(generator = "uuid2")
//  @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountNo;
    private Double amount;
    private String cardType;
    
    @OneToOne
    @JsonBackReference
    @JoinColumn(name = "passenger_id", referencedColumnName = "id")
    private PassengerInfo passengerInfo;

}
