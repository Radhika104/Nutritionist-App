package com.stackroute.nutritionist.recommendedfoodservice.exception;

@SuppressWarnings("serial")
public class FoodAlreadyExistsException extends Exception{

	 private String message;

	    public FoodAlreadyExistsException(String message) {
	        super(message);
	        this.message = message;
	    }

	    public String getMessage()
	    {return this.message;}

	    @Override
	    public String toString() {
	        return "FoodAlreadyExistsException -> "+message;
	    }
}
