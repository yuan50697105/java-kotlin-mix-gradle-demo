package com.example.demo.service.impl;

import com.example.demo.entity.JavaTable;
import com.example.demo.service.JavaTableDaoFactory;
import com.example.demo.service.JavaTableService;
import org.springframework.stereotype.Service;

@Service
public class JavaTableServiceImpl implements JavaTableService {
    private JavaTableDaoFactory javaTableDaoFactory;

    @Override
    public void saveData(JavaTable table, String type) {
        javaTableDaoFactory.saveData(table, type);
    }
}
