package com.br.octo.hruser.resources;

import com.br.octo.hruser.entities.User;
import com.br.octo.hruser.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserRepository repository;



    @GetMapping(value = "/{id}")
    public ResponseEntity<User>FindById(@PathVariable Long id){

        User obj = repository.findById(id).get();

        return ResponseEntity.ok(obj);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<User>FindByEmail(@RequestParam String email){

        User obj = repository.findByEmail(email);

        return ResponseEntity.ok(obj);
    }
}
