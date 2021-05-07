package com.mycompany.sone.security;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

//@Repository
public interface UserMapper {
    @Insert("INSERT INTO users(email, password, authority, enabled) VALUES (#{email}, #{password}, #{authority}, true)")
    public boolean insertUser(Users users);
    
    //로그인시 사용
    @Select("SELECT * FROM users WHERE email = #{email}")
    public CustomUserDetails getUser(@Param("email") String email);
    //public Users getUser(@Param("email") String email);
      
}


//@Insert("INSERT INTO authorities(email, authority) VALUES (#{email}, #{authority})")
//public boolean insertAuthority(
//		@Param("email") String email, 
//		@Param("authority") String authority);

