package com.example.L14springsecuritydemo.repo;

import com.example.L14springsecuritydemo.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepo extends JpaRepository<AppUser, Long> {

    AppUser findByUsername(String user);
}
