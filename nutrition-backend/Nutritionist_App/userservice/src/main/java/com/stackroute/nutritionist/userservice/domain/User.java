package com.stackroute.nutritionist.userservice.domain;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Entity class for storing data into the database using JPA
 */

@Entity

/**
 * Lombok annotations for generating no argument constructor
 * For generating all argument constructor
 * For generating Getters and Setters
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class User {

    /**
     * Annotating emailId with @Id to specify primary key
     */
    @Id
    private String emailId;
    private String password;
    private String firstName;
    private String lastName;
	
 
   
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}