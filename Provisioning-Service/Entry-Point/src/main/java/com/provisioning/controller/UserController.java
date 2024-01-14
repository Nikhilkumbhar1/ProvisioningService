package com.provisioning.controller;

import com.provisioning.dao.UserDataProvider;
import com.provisioning.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDataProvider provider;


    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody User user){
        String msg = provider.createUser(user);
        return new ResponseEntity<String>(msg, HttpStatus.CREATED);
    }


   @GetMapping("getUsers")
   public ResponseEntity<List<User>> getUsers(){
     List<User> users = provider.getAllUsers();
     return new ResponseEntity<List<User>>(users,HttpStatus.OK);
    }

    @GetMapping("getUser/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id){
        User user = provider.getUserbyId(id);
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity<String> updateUser(@RequestBody User user){
        String msg = provider.updateUser(user);
        return new ResponseEntity<String>(msg,HttpStatus.OK);
    }



}
