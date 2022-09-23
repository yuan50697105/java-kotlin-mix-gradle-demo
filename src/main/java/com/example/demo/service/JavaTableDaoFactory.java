package com.example.demo.service;

import com.example.demo.entity.JavaTable;

public interface JavaTableDaoFactory {
    void saveData(JavaTable data, String type);

    enum DaoType {
        PLUS("plus"),
        FLUENT("fluent"),
        ;

        private final String type;

        DaoType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }

        public static String getType(String type) {
            for (DaoType value : values()) {
                if (value.type.equals(type)) {
                    return type;
                }
            }
            throw new IllegalArgumentException(type);
        }
    }

}
