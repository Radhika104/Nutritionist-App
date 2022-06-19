package com.stackroute.nutritionist.recommendedfoodservice.service;

import com.stackroute.nutritionist.recommendedfoodservice.domain.Food;
import com.stackroute.nutritionist.recommendedfoodservice.domain.User;
import com.stackroute.nutritionist.recommendedfoodservice.exception.FoodAlreadyExistsException;
import com.stackroute.nutritionist.recommendedfoodservice.exception.UserAlreadyExistsException;
import com.stackroute.nutritionist.recommendedfoodservice.exception.UserNotFoundException;


public interface FoodService {

    boolean saveUser(User user) throws UserAlreadyExistsException;

    User getUser(String userId) throws UserNotFoundException;

    User updateUser(String userId,Food food) throws UserNotFoundException, FoodAlreadyExistsException;

    User updateFood(Food food,String userId) throws UserNotFoundException;
}
