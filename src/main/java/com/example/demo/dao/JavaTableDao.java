package com.example.demo.dao;

import com.example.demo.entity.JavaTable;

public interface JavaTableDao {
    String getType();

    void saveData(JavaTable data);
}
