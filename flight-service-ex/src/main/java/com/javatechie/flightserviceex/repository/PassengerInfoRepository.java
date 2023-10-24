package com.javatechie.flightserviceex.repository;

import com.javatechie.flightserviceex.entity.PassengerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Map;

public interface PassengerInfoRepository extends JpaRepository<PassengerInfo, Long> {

    @Query(value = "select amount from acc_bal_map where acc_name = :accNo", nativeQuery = true)
    Map<String, Object> getBalance(@Param("accNo") String accNo);

}
