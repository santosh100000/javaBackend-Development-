package com.example.L08SpringJPAdemo.repository;

import com.example.L08SpringJPAdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//Describe in generic Entity for which we need and type of primary key
@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
       //Define a method defination,
    //multiple employee could have name, so returns list of employee,
 // JPA has particular convention on method name, reads the method name and do the job
    List<Employee> findByName(String name);
}
