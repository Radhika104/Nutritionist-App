package com.stackroute.nutritionist.userservice.controller;


import com.stackroute.nutritionist.userservice.domain.User;
import com.stackroute.nutritionist.userservice.domain.UserCredentialsDTO;
import com.stackroute.nutritionist.userservice.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * RestController annotation is used to create Restful web services using Spring MVC
 */
@RestController
/**
 * RequestMapping annotation maps HTTP requests to handler methods
 */
@RequestMapping("/userservice")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    private UserServiceImpl service;

    /*
    Constructor auto wiring
     */
    @Autowired
    public UserController(UserServiceImpl service) {
        this.service = service;
    }

    /*
        Mapping for registering user
     */
    @PostMapping("register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        try {
        	
            return new ResponseEntity<User>(service.saveUser(user), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

      /*
        Mapping for login of existing user
     */
    @PostMapping("login")
    public Map<?, ?> login(@RequestBody UserCredentialsDTO credentials) throws Exception {
        if(credentials.getEmailId() == null || credentials.getPassword() == null)
            throw new Exception("Email and password cannot be empty");
        return service.authenticateUser(credentials);
    }

    /*
        Mapping for getting user details based on emailId
     */

    @GetMapping("/user/{emailId}")
    public ResponseEntity<?> getUserDetails(@PathVariable String emailId) {
        try {
            return new ResponseEntity<User>(service.getUser(emailId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }



}