package com.example.demo.service;

import com.example.demo.entity.JavaTable;
import com.example.demo.entity.dto.Pagination;
import com.example.demo.entity.dto.JavaTableWrapper;

import java.util.List;

public interface JavaTableDaoFactory {
    void saveData(JavaTable data, String type);

    void updateData(JavaTable convertForUpdate, String type);

    JavaTable get(Long id, String type);

    List<JavaTable> getList(JavaTableWrapper wrapper, String type);

    Pagination<JavaTable> getPage(JavaTableWrapper wrapper, int page, int size, String type);

    void deleteData(Long[] id, String type);

    enum DaoType {
        PLUS,
        FLUENT,
        JPA,
        ;


        public static String getType(String type) {
            for (DaoType value : values()) {
                if (value.name().equalsIgnoreCase(type)) {
                    return type;
                }
            }
            throw new IllegalArgumentException(type);
        }
    }

}
