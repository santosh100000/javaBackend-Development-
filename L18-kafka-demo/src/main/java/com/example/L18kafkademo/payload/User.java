package com.example.L18kafkademo.payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


@JsonIgnoreProperties
@Data
public class User {
    private int id;
    private String firstName;
    private String lastName;


}
