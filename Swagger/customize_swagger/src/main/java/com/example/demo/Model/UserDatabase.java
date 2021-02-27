package com.example.demo.Model;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class UserDatabase {

    public List<User> getAllUsers(){
        User user=new User(1,"prajul","sangamner");
        User user2=new User(2,"onkar","sangamner");
        return Stream.of(user,user2).collect(Collectors.toList());
    }
}
