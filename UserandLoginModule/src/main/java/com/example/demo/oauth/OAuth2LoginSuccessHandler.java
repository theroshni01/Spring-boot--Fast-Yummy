package com.example.demo.oauth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.example.demo.AuthenticationProvider;
import com.example.demo.User;
import com.example.demo.UserServices;


@Component
public class OAuth2LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	@Autowired
	private UserServices userServices;
	
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		CustomOAuth2User oAuth2User = (CustomOAuth2User) authentication.getPrincipal();
		String email =oAuth2User.getEmail();
		User user = userServices.getUserByEmail(email);
		String name = oAuth2User.getName();
		
		if(user == null) {
			// register as a new user
			userServices.createNewUserAfterOAuthLoginSuccess(
					email, name, AuthenticationProvider.GOOGLE);
			
			}
		else
		{
			//update existing user
			userServices.updateCustomerAfterOAuthLoginSuccess(user, name, AuthenticationProvider.GOOGLE);
				
		}
		
		
		System.out.println("User's email:" + email);
		
		super.onAuthenticationSuccess(request, response, authentication);
	}

	
	
}

