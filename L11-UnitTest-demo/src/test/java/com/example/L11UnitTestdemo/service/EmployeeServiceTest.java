package com.example.L11UnitTestdemo.service;

import com.example.L11UnitTestdemo.dto.EmployeeDetailDTO;
import com.example.L11UnitTestdemo.entity.Address;
import com.example.L11UnitTestdemo.entity.Employee;
import com.example.L11UnitTestdemo.repository.IEmployeeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

public class EmployeeServiceTest {

    private AutoCloseable autoCloseable;

    @Mock
    private IEmployeeRepository employeeRepository;

    private EmployeeService employeeService;
    private EmployeeDetailDTO employeeDetailDTO;
    private Employee employee;

    @BeforeEach
    public void setUp(){
        autoCloseable = MockitoAnnotations.openMocks(this);
        employeeService = new EmployeeService(employeeRepository);
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
    public void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    public  void createEmployee(){
        when(employeeRepository.save(any())).thenReturn(employee);
        Employee actual = employeeService.createEmployee(employeeDetailDTO);
        assertThat(actual).isEqualTo(employee);
    }
}
