package com.stackroute.nutritionist.favouritefoodservice.service;

import java.util.List;
import java.util.Optional;

import com.stackroute.nutritionist.favouritefoodservice.domain.Food;
import com.stackroute.nutritionist.favouritefoodservice.domain.User;
import com.stackroute.nutritionist.favouritefoodservice.exception.FoodAlreadyExistsException;
import com.stackroute.nutritionist.favouritefoodservice.exception.UserAlreadyExistsException;
import com.stackroute.nutritionist.favouritefoodservice.exception.UserNotFoundException;
import com.stackroute.nutritionist.favouritefoodservice.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FoodServiceImpl implements FoodService{

    @Autowired
    private FoodRepository foodRepository;

    @Override
    public boolean saveUser(User user) throws UserAlreadyExistsException {
        final Optional<User> object = foodRepository.findById(user.getEmailId());

        if (object.isPresent()) {
            throw new UserAlreadyExistsException("Unable to save User,User already exists");
        }
        foodRepository.save(user);

        return true;
    }



    @Override
    public User getUser(String userId) {
        return foodRepository.findByEmailId(userId);
    }

    @Override
    public User updateUser(String emailId ,Food food) throws UserNotFoundException,FoodAlreadyExistsException
    {
        final User user = foodRepository.findById(emailId).orElse(null);
        if (food == null) {
            throw new UserNotFoundException("Unable to update. User not found");
        }
        List<Food> f=user.getFoods();
        for(Food foo : f)
        {
        	if(foo.getFdcId()==food.getFdcId())
        	{
        		 throw new FoodAlreadyExistsException("Unable to update. Food already added");	
        	}
        }
        user.getFoods().add(food);
        foodRepository.save(user);
        return user;
    }

    @Override
    public User updateFood(Food food, String userId) throws UserNotFoundException {
        final User user = foodRepository.findById(userId).orElse(null);
        if (food == null) {
            throw new UserNotFoundException("Unable to Delete. User not found");
        }
        user.getFoods().remove(food);
        foodRepository.save(user);
        return user;
    }


}


