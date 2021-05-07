package com.mycompany.sone.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {
    
    @Autowired
    private UserMapper userMapper;

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	@Override //로그인시, 자동으로 loadUserByUsername() 메소드를 호출한다
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("username : " + username); //★사실 email

		CustomUserDetails userDetails = userMapper.getUser(username);
        if(userDetails == null) {
            throw new UsernameNotFoundException(username);
        }
        userDetails.setUsername(username); //사실 email //★이거 안하면 username null인 채로
        System.out.println("userDetails의 username : " + userDetails.getUsername());
        System.out.println("userDetails의 pwd : " + userDetails.getPassword());
        
        List<GrantedAuthority> authorities  
        = (List<GrantedAuthority>) userDetails.getAuthorities();

        return userDetails;
    }
}
 
