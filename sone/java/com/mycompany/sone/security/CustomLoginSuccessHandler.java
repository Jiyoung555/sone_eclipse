package com.mycompany.sone.security;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;

@Configuration
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        
//        String email = authentication.getName(); 
//        //로그인 email 찾아옴 //CustomUserDetailsService에 ★ 해뒀기 때문에
//        System.out.println("email : " + email);

    	
    	HttpSession session = request.getSession();
    	
		CustomUserDetails userDetails = 
				(CustomUserDetails) authentication.getPrincipal();
		
		System.out.println("email : " + userDetails.getUsername());
		//로그인 email 찾아옴 //CustomUserDetailsService에 ★ 해뒀기 때문에
		session.setAttribute("email", "email");

        List<GrantedAuthority> authorities 
        	= (List<GrantedAuthority>) authentication.getAuthorities();
        

        for(GrantedAuthority auth : authorities) {
        	System.out.println("auth : " + auth);
        	
        	if(auth.toString().equals("ROLE_ADMIN")) { //★toString
        		System.out.println("어드민 계정");
        		session.setAttribute("admin", "admin");
        	}
        }
        
        System.out.println("로그인 성공");
        response.sendRedirect("/");
    }
	
}