package com.example.L08SpringJPAdemo.service;

import com.example.L08SpringJPAdemo.CradNotCreatedException;
import com.example.L08SpringJPAdemo.dto.EmployeeDetailDTO;
import com.example.L08SpringJPAdemo.entity.Address;
import com.example.L08SpringJPAdemo.entity.Employee;
import com.example.L08SpringJPAdemo.repository.IEmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {


    private static Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

    private String nuller = null;
    @Autowired
    private IEmployeeRepository employeeRepository;
    private boolean cardCraeted = true;

    @Transactional(rollbackFor = {CradNotCreatedException.class})
    public Employee createEmployee(EmployeeDetailDTO employeeDetailDTO) throws CradNotCreatedException {
        Employee employee = new Employee();
        employee.setName(employeeDetailDTO.getName());
        employee.setEmail(employeeDetailDTO.getEmail());
        Address address = new Address();
        address.setLine1(employeeDetailDTO.getLine1() );
        address.setLine2(employeeDetailDTO.getLine2() );
        address.setCity(employeeDetailDTO.getCity() );
        employee.setAddress(address);
        employeeRepository.save(employee);
        LOGGER.info("saved Employee");
        cardCraeted = false;
        if(!cardCraeted){
            throw new CradNotCreatedException();
        }
        return employee;
    }
}
