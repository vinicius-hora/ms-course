package com.devsuperior.hrworker.resources;

import com.devsuperior.hrworker.entities.Worker;
import com.devsuperior.hrworker.repositories.WorkerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RefreshScope
@RestController
@RequestMapping(value = "/workers")
@RequiredArgsConstructor
@Slf4j
public class WorkerResource {

    @Value("${test.config}")
    private String testeConfig;

    private final Environment environment;

    private final WorkerRepository workerRepository;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll(){
        List<Worker> list = workerRepository.findAll();

        return ResponseEntity.ok(list);

    }
    @GetMapping(value = "/configs")
    public ResponseEntity<Void> getConfigs(){
        log.info("CONFIG: {}", testeConfig);

        return ResponseEntity.noContent().build();

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findByid(@PathVariable Long id){
        log.info("PORT: {}", environment.getProperty("local.server.port"));
        Worker worker = workerRepository.findById(id).get();

        return ResponseEntity.ok(worker);

    }



}
