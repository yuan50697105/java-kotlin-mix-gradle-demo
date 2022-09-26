package com.example.demo.constants;

public enum DaoType {
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
