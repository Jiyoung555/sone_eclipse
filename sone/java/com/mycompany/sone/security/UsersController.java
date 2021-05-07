package com.mycompany.sone.security;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class UsersController {
	//회원가입, 로그인 url GetMapping 조회
	//회원가입 form post 제출
	//로그인, 로그아웃 form post 제출은 만들지 x (시큐리티가 자체적으로 관리)
	
    @Autowired
    private UserMapper userMapper; //인터페이스임 (xml 말고)
     
    //회원가입 폼데이터 받아오기
    //@ResponseBody
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String create(@ModelAttribute Users users) {
    	users.setAuthority("ROLE_USER");
        userMapper.insertUser(users);
        //userMapper.insertAuthority(users.getEmail(), "ROLE_USER");
        return "redirect:/login";
    }
    
    //-----------------------------------
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "members/customLogin";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signup(Model model) {
        Users user = new Users();
        model.addAttribute("user", user);//jsp에 <f:input path="email"
        return "members/customSignUp";
    }
    
}
