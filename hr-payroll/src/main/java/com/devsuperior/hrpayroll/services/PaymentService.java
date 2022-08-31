package com.devsuperior.hrpayroll.services;


import com.devsuperior.hrpayroll.entities.Payment;
import com.devsuperior.hrpayroll.entities.Worker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentService {

    @Value("{hr-worker.host}")
    private String workerHost;

    private final RestTemplate restTemplate;

    public Payment getPayment(long workerId, int days){

        Map<String, String> urlVariables = new HashMap<>();
        urlVariables.put("id", ""+workerId);
        log.info( "URL: {}", workerHost);

        Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, urlVariables);

        return new Payment(worker.getName(), worker.getDailyIncome(), days);

    }
}
