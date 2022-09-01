package com.devsuperior.hrpayroll.services;


import com.devsuperior.hrpayroll.entities.Payment;
import com.devsuperior.hrpayroll.entities.Worker;
import com.devsuperior.hrpayroll.feingclients.WorkerFeingClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentService {

    private final WorkerFeingClient workerFeingClient;

    public Payment getPayment(long workerId, int days){



        Worker worker = workerFeingClient.findByid(workerId).getBody();

        return new Payment(worker.getName(), worker.getDailyIncome(), days);

    }
}
