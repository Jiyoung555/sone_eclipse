package com.mycompany.sone.security;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class CustomLoginFailureHandler implements AuthenticationFailureHandler {

	@Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException exception)
            throws IOException, ServletException {

        String msg = null;

        if (exception instanceof UsernameNotFoundException) { 
            msg = "InvalidEmail";

        } else if(exception instanceof BadCredentialsException) { 
            msg = "WrongPwd";
            //Invalid email or wrong password.
            //비회원이라도 여기 에러로 오는게 보안 안전 (해커에게 정보 적게 주게)

        } else if(exception instanceof LockedException) {
            msg = "This account has been locked.";

        } else if(exception instanceof DisabledException) {
            msg = "This account is disabled now.";

        } else if(exception instanceof AccountExpiredException) {
            msg = "This account has been expired";

        } else if(exception instanceof CredentialsExpiredException) {
            msg = "The password has been expired.";

        }

        //request.getRequestDispatcher(defaultFailureUrl).forward(request, response);
        //setDefaultFailureUrl("/login?error=true&exception="+msg);
        
        System.out.println("로그인 실패");
        response.sendRedirect(request.getContextPath() + "/login?error=true&exception="+msg);

    }


}

