package com.br.octo.hroauth.resources;

import com.br.octo.hroauth.entities.User;
import com.br.octo.hroauth.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping(value = "/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email){

        try {
            User user = service.findByEmail(email);

            return ResponseEntity.ok(user);
        }
        catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }


    }
}
