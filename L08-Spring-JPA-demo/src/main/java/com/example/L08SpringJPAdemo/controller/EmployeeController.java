package com.example.L08SpringJPAdemo.controller;

import com.example.L08SpringJPAdemo.CradNotCreatedException;
import com.example.L08SpringJPAdemo.dto.EmployeeDetailDTO;
import com.example.L08SpringJPAdemo.entity.Employee;
import com.example.L08SpringJPAdemo.repository.IEmployeeRepository;
import com.example.L08SpringJPAdemo.service.EmployeeService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private IEmployeeRepository employeeRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("/names")
    public ResponseEntity<List<String>> getAllNames(){
        Query query = entityManager.createNativeQuery("select name from employee");
        List<String> list = query.getResultList();
        return ResponseEntity.ok(list);

    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        employeeRepository.save(employee);
        return ResponseEntity.ok(employee);

    }

    @PostMapping("/addEmployee")
    public ResponseEntity<Employee> createEmployees(@RequestBody EmployeeDetailDTO employeeDetailDTO) throws CradNotCreatedException {
      Employee employee =  employeeService.createEmployee(employeeDetailDTO);
        return ResponseEntity.ok(employee);

    }

    @GetMapping()
    public ResponseEntity<List<Employee>> getEmployee(@RequestParam String name){
    List<Employee>  employee = employeeRepository.findByName(name);
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id){
        Employee employee = employeeRepository.findById(id).get();
        return ResponseEntity.ok(employee);
    }
}
