package com.example.onetoonefind.dao;


import com.example.onetoonefind.entity.Instructor;

public interface AppDAO {
    void save(Instructor instructor);

    Instructor findById(int id);
}
