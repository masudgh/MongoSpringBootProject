package com.masud;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;


public class People {
	
	@Id 
	@Field("_id")
	private String id;
	
	@Field("first_name")
	private String firstName;
	
	@Field("last_name")
	private String lastName;

//	public Person(String firstName, String lastName) {
//		super();
//		this.firstName = firstName;
//		this.lastName = lastName;
//	}

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

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	
}
