package com.stackroute.nutritionist.favouritefoodservice.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stackroute.nutritionist.favouritefoodservice.domain.User;
import com.stackroute.nutritionist.favouritefoodservice.exception.UserNotFoundException;
import com.stackroute.nutritionist.favouritefoodservice.exception.FoodAlreadyExistsException;
import com.stackroute.nutritionist.favouritefoodservice.exception.UserAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import com.stackroute.nutritionist.favouritefoodservice.domain.Food;
import com.stackroute.nutritionist.favouritefoodservice.service.FoodService;
import io.jsonwebtoken.Jwts;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/fav")
@CrossOrigin(origins = "http://localhost:3000")
public class FoodController {

    @Autowired
    private FoodService FoodService;

    @PostMapping("users/{emailId}")
    public ResponseEntity<?> saveUser(@PathVariable String emailId, @RequestBody Food food) {
        ResponseEntity<?> responseEntity;
        try
        {   User user= new User(emailId,List.of(food));
            FoodService.saveUser(user);
            responseEntity = new ResponseEntity<User>(user, HttpStatus.CREATED);
        } catch (UserAlreadyExistsException e) {
            responseEntity = new ResponseEntity<String>(e.getMessage() , HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @PutMapping("users/{emailId}")
    public ResponseEntity<?> updateUser(@PathVariable("emailId") String emailId, @RequestBody Food food) {
        ResponseEntity<?> responseEntity;
        try
        {
            User fetchedUser = FoodService.updateUser(emailId,food);
            responseEntity = new ResponseEntity<User>(fetchedUser, HttpStatus.OK);
        } catch (UserNotFoundException e) {
            responseEntity = new ResponseEntity<String>( e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (FoodAlreadyExistsException e) {
			// TODO Auto-generated catch block
        	responseEntity = new ResponseEntity<String>( e.getMessage(), HttpStatus.NOT_FOUND);
			e.printStackTrace();
		}
        return responseEntity;
    }


    @GetMapping("users/{emailId}")
    public ResponseEntity<?> getUser(@PathVariable String emailId) {
        ResponseEntity<?> responseEntity;
        try {
            responseEntity = new ResponseEntity<User>(FoodService.getUser(emailId), HttpStatus.OK);
        } catch (UserNotFoundException e) {
            responseEntity = new ResponseEntity<String>( e.getMessage(), HttpStatus.NOT_FOUND);  }
        return responseEntity;
    }


    @DeleteMapping("users/{emailId}")
    public ResponseEntity<?> deleteFood(@PathVariable String emailId , @RequestBody Food food) {
        ResponseEntity<?> responseEntity;
        try {
            FoodService.updateFood(food,emailId);
            responseEntity = new ResponseEntity<String>("food deleted successfully", HttpStatus.OK);
        } catch (UserNotFoundException e) {
            responseEntity = new ResponseEntity<String>("{ \"message\": \"" + e.getMessage() + "\"}", HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

}



