package com.example.exceptiondemo.rest;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentErrorResponse {
    private int status;
    private String message;
    private long timeStamp;
}
