package com.example.L14springsecuritydemo;

import com.example.L14springsecuritydemo.repo.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;

public class AppUsersDetailManagers implements UserDetailsManager {

    @Autowired
    private AppUserRepo appUserRepo;



    @Override
    public void createUser(UserDetails user) {

    }

    @Override
    public void updateUser(UserDetails user) {

    }

    @Override
    public void deleteUser(String username) {

    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {

    }

    @Override
    public boolean userExists(String username) {
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = appUserRepo.findByUsername(username);
        if(userDetails == null){
            throw new UsernameNotFoundException("USER NOT FOUND");
        }
        return userDetails;

    }
}
