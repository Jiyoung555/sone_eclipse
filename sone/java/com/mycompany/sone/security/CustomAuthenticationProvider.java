package com.mycompany.sone.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;

//로그인 시도시 여기로 옴 (실패할 때만 오는 듯)
public class CustomAuthenticationProvider implements AuthenticationProvider {
    
    @Autowired
    private CustomUserDetailsService userDetailsService;

	public void setUserDetailsService(CustomUserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}    
 
    @SuppressWarnings("unchecked")
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        
        String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();
        
        System.out.println("로그인 시도 이메일 : " + username);
        System.out.println("로그인 시도 비밀번호 : " + password);
        
        CustomUserDetails userDetails 
        = (CustomUserDetails) userDetailsService.loadUserByUsername(username);
        
        if(!matchPassword(password, userDetails.getPassword())) {//아래 메소드
        	System.out.println("틀린 비밀번호");
            throw new BadCredentialsException(username);
        }
 
        if(!userDetails.isEnabled()) {
            throw new BadCredentialsException(username);
        }
        
        return new UsernamePasswordAuthenticationToken(
        		username, password, userDetails.getAuthorities());
    }

	@Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
    
    private boolean matchPassword(String loginPwd, String password) {
        return loginPwd.equals(password);
    }
 
}

