package com.example.demo;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Profile;

@Entity
@Table(name = "profile")
public class Profiles {
	
    private Long id;
	
	
    private String Full_Name;
 
    private String Email_ID;
   
    private String Phone_Number;
    
    private String DOB;
    
    private String Address;

    private String Gender;



	protected Profiles() {
		
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFull_Name() {
		return Full_Name;
	}


	public void setFull_Name(String full_Name) {
		this.Full_Name = full_Name;
	}


	public String getEmail_ID() {
		return Email_ID;
	}


	public void setEmail_ID(String email_ID) {
		this.Email_ID = email_ID;
	}


	public String getPhone_Number() {
		return Phone_Number;
	}


	public void setPhone_Number(String phone_Number) {
		this.Phone_Number = phone_Number;
	}


	public String getDOB() {
		return DOB;
	}


	public void setDOB(String dOB) {
		this.DOB = dOB;
	}


	public String getAddress() {
		return Address;
	}


	public void setAddress(String address) {
		this.Address = address;
	}


	public String getGender() {
		return Gender;
	}


	public void setGender(String gender) {
		this.Gender = gender;
	}


	public static void saveAll(List<Profile> of) {
		// TODO Auto-generated method stub
		
	}
	
}
