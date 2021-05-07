package com.mycompany.sone.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {

    private String username;
    private String password;
    private String authority; //★

   
    public Collection<? extends GrantedAuthority> getAuthorities(){
	    List<GrantedAuthority> authorities = new ArrayList();
	    System.out.println("authority : " + authority);
	    
	    for (String role : authority.split(",")) { //★
	    	authorities.add(new SimpleGrantedAuthority(role));
	    }
	    
	    return authorities;
        
        
    }


    public void setPassword(String password){
        this.password = password;
    }
   
    public String getPassword(){
        return password;
    }
   
    public void setUsername(String username){
        this.username = username;
    }
	public String getUsername(){
        return username;
    }    
    
   
    public boolean isAccountNonExpired(){
        return true;
    }
   
    public boolean isAccountNonLocked(){ 
        return true;
    }
   
    public boolean isCredentialsNonExpired(){
        return true;
    }
   
    public boolean isEnabled(){
        return true;
    }	
	
}
