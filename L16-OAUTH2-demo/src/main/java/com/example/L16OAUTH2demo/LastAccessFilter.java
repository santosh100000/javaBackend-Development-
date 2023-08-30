package com.example.L16OAUTH2demo;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;

@Component
public class LastAccessFilter extends HttpFilter {

    private static Logger LOGGER= LoggerFactory.getLogger(LastAccessFilter.class);

    @Autowired
    private MyUserRepo myUserRepo;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

     try{
         OAuth2User auth2User = (OAuth2User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = (String) auth2User.getAttributes().get("email");
         MyUser user = myUserRepo.findByEmail(email);
         if(user ==null){
             user = new MyUser();
             user.setEmail(email);
             user.setLastAccess(new Date());
         }
         myUserRepo.save(user);
     }catch (Exception e ){
         LOGGER.error("exception while setting last access");
         e.printStackTrace();
     }

        chain.doFilter(request, response);
    }
}
