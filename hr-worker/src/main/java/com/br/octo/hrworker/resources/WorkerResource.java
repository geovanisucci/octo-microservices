package com.br.octo.hrworker.resources;

import com.br.octo.hrworker.entities.Worker;
import com.br.octo.hrworker.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

    @Autowired
    private WorkerRepository repository;

    @GetMapping
    public ResponseEntity<List<Worker>> FindAll(){

        List<Worker> list = repository.findAll();

        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker>FindById(@PathVariable Long id){
        Worker obj = repository.findById(id).get();

        return ResponseEntity.ok(obj);
    }
}
