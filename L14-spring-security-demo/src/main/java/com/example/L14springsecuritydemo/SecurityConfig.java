package com.example.L14springsecuritydemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
       return new BCryptPasswordEncoder();
//        return NoOpPasswordEncoder.getInstance();
    }

//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails user1 = User.builder().username("santosh").
//                password(passwordEncoder().encode("password"))
//                .roles("USER").build();
//        UserDetails user2 = User.builder().username("ajay").password(passwordEncoder().encode("ajay123"))
//                .roles("ADMIN").build();
//        return new InMemoryUserDetailsManager(user1, user2);
//    }

    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("abc123"));
        //$2a$10$PyyO8kOBCZd8l27andfUwO/D0xCz2vkABwpTXk8Yl2Ipf7fbQoKJK
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf((httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable())).
                authorizeHttpRequests((auth) ->{
                    auth.requestMatchers("/product/**").hasAuthority("ADMIN").
                            requestMatchers("/public/**").permitAll()
                            .anyRequest().authenticated();
                })
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
        return httpSecurity.build();
    }
}
