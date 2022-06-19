package com.stackroute.nutritionist.favouritefoodservice.repository;

import com.stackroute.nutritionist.favouritefoodservice.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends MongoRepository<User,String> {
    public User findByEmailId(String emailId);
}
