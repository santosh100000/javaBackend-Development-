package com.example.L11UnitTestdemo.repository;

import com.example.L11UnitTestdemo.entity.Address;
import com.example.L11UnitTestdemo.entity.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class IEmployeeRepositoryTest {

    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    private Employee employee;

    @BeforeEach
    void setup(){
        Address address1 = Address.builder()
        .line1("U2").line2("Franklin").city("SYD").
                build();
        employee = Employee.builder()
                .email("test1@gmail.com").name("duku").
                address(address1).
                build();
        iEmployeeRepository.save(employee);

    }

    @AfterEach
    void tearDown(){
         iEmployeeRepository.deleteAll();
    }

    @Test
    void findByName() {
        List<Employee> actualList = iEmployeeRepository.findByName("sduku");
        assertThat(actualList.size()).isEqualTo(1);
        Employee actualEmployee = actualList.get(0);
        assertThat(actualEmployee).isEqualTo(employee);
    }
}