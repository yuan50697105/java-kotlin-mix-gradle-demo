package com.example.demo.service;

import com.example.demo.entity.JavaTable;
import com.example.demo.entity.dto.Pagination;
import com.example.demo.entity.dto.JavaTableAddDTO;
import com.example.demo.entity.dto.JavaTableUpdateDTO;
import com.example.demo.entity.dto.JavaTableWrapper;

import java.util.List;

public interface JavaTableService {
    void saveData(JavaTableAddDTO table, String type);

    void updateData(JavaTableUpdateDTO table, String type);

    JavaTable get(Long id, String type);

    List<JavaTable> getList(JavaTableWrapper wrapper, String type);

    Pagination<JavaTable> getPage(JavaTableWrapper wrapper, int page, int size, String type);

    void deleteData(Long[] id, String type);
}
