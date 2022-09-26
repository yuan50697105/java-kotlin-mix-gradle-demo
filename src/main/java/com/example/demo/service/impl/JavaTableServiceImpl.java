package com.example.demo.service.impl;

import com.example.demo.converter.JavaTableConverter;
import com.example.demo.dao.factory.JavaTableDaoFactory;
import com.example.demo.entity.JavaTable;
import com.example.demo.entity.dto.JavaTableAddDTO;
import com.example.demo.entity.dto.JavaTableUpdateDTO;
import com.example.demo.entity.dto.JavaTableWrapper;
import com.example.demo.entity.dto.Pagination;
import com.example.demo.service.JavaTableService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JavaTableServiceImpl implements JavaTableService {
    private final JavaTableDaoFactory javaTableDaoFactory;
    private final JavaTableConverter javaTableConverter;

    public JavaTableServiceImpl(JavaTableDaoFactory javaTableDaoFactory, JavaTableConverter javaTableConverter) {
        this.javaTableDaoFactory = javaTableDaoFactory;
        this.javaTableConverter = javaTableConverter;
    }

    @Override
    public void saveData(JavaTableAddDTO table, String type) {
        JavaTable data = javaTableConverter.convertForAdd(table);
        javaTableDaoFactory.saveData(data, type);
    }

    @Override
    public void updateData(JavaTableUpdateDTO table, String type) {
        javaTableDaoFactory.updateData(javaTableConverter.convertForUpdate(table), type);
    }

    @Override
    public JavaTable get(Long id, String type) {
        return javaTableDaoFactory.get(id, type);
    }

    @Override
    public List<JavaTable> getList(JavaTableWrapper wrapper, String type) {
        return javaTableDaoFactory.getList(wrapper, type);
    }

    @Override
    public Pagination<JavaTable> getPage(JavaTableWrapper wrapper, int page, int size, String type) {
        return javaTableDaoFactory.getPage(wrapper,page,size,type);
    }

    @Override
    public void deleteData(Long[] id, String type) {
        javaTableDaoFactory.deleteData(id, type);
    }
}
