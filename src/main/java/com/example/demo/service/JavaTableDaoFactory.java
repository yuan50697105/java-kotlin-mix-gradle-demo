package com.example.demo.service;

import com.example.demo.entity.JavaTable;

public interface JavaTableDaoFactory {
    void saveData(JavaTable data, String type);

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
