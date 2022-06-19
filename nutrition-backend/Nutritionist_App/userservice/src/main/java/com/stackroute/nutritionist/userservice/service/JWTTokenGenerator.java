package com.stackroute.nutritionist.userservice.service;

import java.util.Map;

/**
 * Interface for JWT Token Generation
 */
public interface JWTTokenGenerator {

    /**
     * Abstract method for token generation
     */

    Map<String, String> generateToken(String emailId);
}
