package com.example.demo.dao;

import com.example.demo.entity.JavaTable;
import com.example.demo.entity.dto.Pagination;
import com.example.demo.entity.dto.JavaTableWrapper;

import java.util.List;

public interface JavaTableDao {
    String getType();

    void saveData(JavaTable data);

    void updateData(JavaTable javaTable);

    JavaTable get(Long id);

    List<JavaTable> getList(JavaTableWrapper wrapper);

    Pagination<JavaTable> getPage(JavaTableWrapper wrapper, int page, int size);

    void deleteData(Long[] id);
}
