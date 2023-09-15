package com.example.L17emaildemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailRequest {
    private String toEmail;
    private String subject;
    private String body;
    private String cc;





}
