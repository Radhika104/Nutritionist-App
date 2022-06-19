package com.stackroute.nutritionist.recommendedfoodservice.repository;

import com.stackroute.nutritionist.recommendedfoodservice.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends MongoRepository<User,String> {
    public User findByEmailId(String emailId);
}
