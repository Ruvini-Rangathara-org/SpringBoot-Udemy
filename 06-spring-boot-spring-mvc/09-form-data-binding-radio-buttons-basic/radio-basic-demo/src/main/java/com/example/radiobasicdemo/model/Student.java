package com.example.radiobasicdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
    private String firstName;
    private String lastName;
    private String country;
    private String favoriteLanguage;
}
