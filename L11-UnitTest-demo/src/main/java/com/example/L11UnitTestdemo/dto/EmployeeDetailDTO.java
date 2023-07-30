package com.example.L11UnitTestdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDetailDTO {

    private String name;

    private String email;

    private String line1;

    private String line2;

    private String city;
}
