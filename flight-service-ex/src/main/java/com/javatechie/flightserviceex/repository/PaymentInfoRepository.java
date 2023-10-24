package com.javatechie.flightserviceex.repository;

import com.javatechie.flightserviceex.entity.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentInfoRepository extends JpaRepository<PaymentInfo, String> {

}
