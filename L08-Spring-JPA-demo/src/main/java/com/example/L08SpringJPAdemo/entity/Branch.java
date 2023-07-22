package com.example.L08SpringJPAdemo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private String renewalNumber;

    @OneToMany(mappedBy = "branch", fetch = FetchType.EAGER)
    private Set<Employee> employeeSet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
