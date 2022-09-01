package com.devsuperior.hrpayroll.feingclients;

import com.devsuperior.hrpayroll.entities.Worker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "hr-worker", url = "localhost:4103", path = "/workers")
public interface WorkerFeingClient {

    @GetMapping(value = "/{id}")
    ResponseEntity<Worker> findByid(@PathVariable Long id);
}
