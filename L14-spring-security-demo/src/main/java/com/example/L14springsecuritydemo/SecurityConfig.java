package com.example.L14springsecuritydemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {



//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
//        UserDetails user1 = User.withDefaultPasswordEncoder().username("rahul").password("password")
//                .roles("USER").build();
//
//        UserDetails user2 = User.withDefaultPasswordEncoder().username("ajay").password("ajay123")
//                .roles("ADMIN").build();
//
//        return new InMemoryUserDetailsManager(user1, user2);
//    }

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);


        return users;
    }


    //Limiting the users access to certain url only
/*
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
      http
              .authorizeHttpRequests((authz) -> authz

                      .requestMatchers("/hello/*").hasRole("USER")
                      .requestMatchers("/product/*").hasRole("ADMIN"))
              .httpBasic(Customizer.withDefaults());
              return http.build();
    }

 */


}
