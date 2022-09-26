package com.example.demo.dao.factory;

import com.example.demo.entity.JavaTable;
import com.example.demo.entity.dto.JavaTableWrapper;
import com.example.demo.entity.dto.Pagination;

import java.util.List;

public interface JavaTableDaoFactory {
    void saveData(JavaTable data, String type);

    void updateData(JavaTable convertForUpdate, String type);

    JavaTable get(Long id, String type);

    List<JavaTable> getList(JavaTableWrapper wrapper, String type);

    Pagination<JavaTable> getPage(JavaTableWrapper wrapper, int page, int size, String type);

    void deleteData(Long[] id, String type);

}
