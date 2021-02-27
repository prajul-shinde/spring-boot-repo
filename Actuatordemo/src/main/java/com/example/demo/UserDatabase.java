package com.example.demo;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class UserDatabase {

    public List<User> getAllUsers(){

       return Stream.of(new User(1,"prajul","prajulshinde@gmail.com","active"),
               new User(2,"onkar","onkarshinde000@gmail.com","inactive")).collect(Collectors.toList());

    }
}
