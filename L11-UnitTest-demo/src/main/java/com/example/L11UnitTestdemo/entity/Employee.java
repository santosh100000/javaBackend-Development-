package com.example.L11UnitTestdemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id // Represents primary key
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false) //col name & desc
    private Long id;

    @Column(unique = true)
    private String email;

    @Column
    private String name;

    @OneToOne(cascade = CascadeType.ALL) //One Employee can have only one address, cascadeALl- access address table while accessing employee table
    private Address address;

    @ManyToOne
    @JsonIgnoreProperties("employeeSet")
    private Branch branch;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
