package com.example.onetoonedelete.dao;


import com.example.onetoonedelete.entity.Instructor;

public interface AppDAO {
    void save(Instructor instructor);

    Instructor findById(int id);

    void deleteById(int id);
}
