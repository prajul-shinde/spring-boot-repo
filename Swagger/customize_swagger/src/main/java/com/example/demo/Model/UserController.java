package com.example.demo.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserDatabase userDatabase;
    @GetMapping("/users")
    public List<User>getAllUsers(){
        return userDatabase.getAllUsers();
    }
}
