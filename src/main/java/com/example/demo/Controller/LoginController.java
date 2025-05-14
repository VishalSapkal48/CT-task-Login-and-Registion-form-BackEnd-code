package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.LoginEntity.LoginEntitys;
import com.example.demo.Service.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {

    @Autowired
    private ServiceLinterface service;

    @PostMapping("/register")
    public String register(@RequestBody LoginEntitys entity) {
        return service.register(entity);
    }
      
  

    @PostMapping("/login")
    public String login(@RequestBody LoginEntitys entity) {
        boolean status = service.login(entity.getEmail(), entity.getPassword());
        return status ? "Login Successful" : "Invalid Credentials";
        
    }
}
