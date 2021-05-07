package com.mycompany.sone.security;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

public class CustomLogoutSuccessHandler implements LogoutSuccessHandler{	

    @Override
    public void onLogoutSuccess(
    		HttpServletRequest request, 
    		HttpServletResponse response, 
    		Authentication authentication) throws IOException, ServletException {
    	
    	System.out.println("authentication : " + authentication);
    	System.out.println("authentication.getDetails() : " + authentication.getDetails());
    	
        if (authentication != null && authentication.getDetails() != null) {
            try {
            	System.out.println("로그아웃");
                 request.getSession().invalidate();
                 
            } catch (Exception e) {
                e.printStackTrace();
            }
        } 
        response.setStatus(HttpServletResponse.SC_OK);
        response.sendRedirect("/login?logout");
        
    }
    
}