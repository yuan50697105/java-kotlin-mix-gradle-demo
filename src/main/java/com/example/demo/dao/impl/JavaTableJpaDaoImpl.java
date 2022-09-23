package com.example.demo.dao.impl;

import com.example.demo.dao.JavaTableDao;
import com.example.demo.entity.JavaTable;
import com.example.demo.repository.JavaTableRepository;
import com.example.demo.service.JavaTableDaoFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class JavaTableJpaDaoImpl implements JavaTableDao {
    private final JavaTableRepository javaTableRepository;

    public JavaTableJpaDaoImpl(JavaTableRepository javaTableRepository) {
        this.javaTableRepository = javaTableRepository;
    }

    @Override
    public String getType() {
        return JavaTableDaoFactory.DaoType.JPA.name();
    }

    @Override
    @Transactional
    public void saveData(JavaTable data) {
        javaTableRepository.save(data);
    }
}
