package com.stackroute.nutritionist.userservice.repository;


import com.stackroute.nutritionist.userservice.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/*
    Annotating with @Repository to specify this class as Repository
 */

@Repository
public interface UserRepository extends CrudRepository<User, String> {

    /*
        Method to find user from database using emailId and password
     */
	
    User findByEmailIdAndPassword(String emailId, String password);
}