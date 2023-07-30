package com.example.L11UnitTestdemo.controller;

import com.example.L11UnitTestdemo.dto.EmployeeDetailDTO;
import com.example.L11UnitTestdemo.entity.Address;
import com.example.L11UnitTestdemo.entity.Employee;
import com.example.L11UnitTestdemo.repository.IEmployeeRepository;
import com.example.L11UnitTestdemo.service.EmployeeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import static org.junit.jupiter.api.Assertions.*;
import org.mockito.junit.jupiter.MockitoExtension;
//@WebMvcTest(EmployeeController.class)
@ExtendWith(MockitoExtension.class)
class EmployeeControllerTest {
    private AutoCloseable autoCloseable;
    @MockBean
    private EmployeeService employeeService;
    private EmployeeDetailDTO employeeDetailDTO;
    private Employee employee;

    @BeforeEach
    public void setUp(){


        Address address1 = Address.builder().
                id(1l).line1("U2").line2("Franklin").city("SYD").
                build();
        employee = Employee.builder().
                id(1l).email("test1@gmail.com").name("duku").
                address(address1).
                build();
        employeeDetailDTO = EmployeeDetailDTO.builder().email("test1@gmail.com").name("duku").
                line1("U2").line2("Franklin").city("SYD").
                build();
    }


    @AfterEach
    void tearDown() {
    }

    @Test
    void createEmployee() {
        when(employeeService.createEmployee(employeeDetailDTO)).thenReturn(employee);
        Employee testedEmployee = employeeService.createEmployee(employeeDetailDTO);
        assertThat(testedEmployee).isEqualTo(employee);
    }

    @Test
    void getEmployee() {
    }
}