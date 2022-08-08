package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

	
	 @Autowired
	    private UserRepository repo;
	     
	    public void processOAuthPostLogin(String username) {
	        User existUser = repo.getUserByUsername(username);
	         
	        if (existUser == null) {
	            User newUser = new User();
	            newUser.setFirstName(username);
	            newUser.setAuthProvider(AuthenticationProvider.GOOGLE);
	                 
	          
	            repo.save(newUser);        
	        }
	         
	    }

		public User getUserByEmail(String email) {
			// TODO Auto-generated method stub
			return null;
		}

		public void createNewUserAfterOAuthLoginSuccess(String email, String name, AuthenticationProvider provider) {
			User user = new User();
			user.setEmail(email);
			user.setFirstName(name);
			user.setAuthProvider(provider);
			
			repo.save(user);
		}

		public void updateCustomerAfterOAuthLoginSuccess(
				User user, String name, AuthenticationProvider provider) {
			user.setFirstName(name);
			user.setAuthProvider(provider);
			
			repo.save(user);
			
		}
}
