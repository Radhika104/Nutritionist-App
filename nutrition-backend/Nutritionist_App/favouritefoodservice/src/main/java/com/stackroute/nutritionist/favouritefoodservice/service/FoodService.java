package com.stackroute.nutritionist.favouritefoodservice.service;

import com.stackroute.nutritionist.favouritefoodservice.domain.Food;
import com.stackroute.nutritionist.favouritefoodservice.domain.User;
import com.stackroute.nutritionist.favouritefoodservice.exception.FoodAlreadyExistsException;
import com.stackroute.nutritionist.favouritefoodservice.exception.UserAlreadyExistsException;
import com.stackroute.nutritionist.favouritefoodservice.exception.UserNotFoundException;


public interface FoodService {

    boolean saveUser(User user) throws UserAlreadyExistsException;

    User getUser(String userId) throws UserNotFoundException;

    User updateUser(String userId,Food food) throws UserNotFoundException, FoodAlreadyExistsException;

    User updateFood(Food food,String userId) throws UserNotFoundException;
}
