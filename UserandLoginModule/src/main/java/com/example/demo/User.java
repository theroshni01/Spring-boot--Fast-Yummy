package com.example.demo;
import java.util.List;

import javax.persistence.*;
import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2ClientProperties.Provider;

@Entity
@Table(name = "users")

public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     
    @Column(nullable = false, unique = true, length = 45)
    private String email;
     
    @Column(nullable = false, length = 64)
    private String password;
     
    @Column(name = "first_name", nullable = false, length = 20)
    private String firstName;
     
    @Column(name = "last_name", nullable = false, length = 20)
    private String lastName;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "auth_provider")
 private AuthenticationProvider authProvider;
    
    public AuthenticationProvider getAuthProvider() {
        return authProvider;
    }
  
    public void setAuthProvider(AuthenticationProvider authProvider) {
        this.authProvider = authProvider;
    }
    
	public Long getId() { 
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstname) {
		this.firstName = firstname;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName; 
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password ) {
		this.password = password;
	}
	
	

	public static void saveAll(List<User> of) {
		// TODO Auto-generated method stub
		
	}
	
} 

