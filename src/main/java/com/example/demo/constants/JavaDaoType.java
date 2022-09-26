package com.example.demo.constants;

public enum JavaDaoType {
    PLUS,
    FLUENT,
    JPA,
    ;


    public static String getType(String type) {
        for (JavaDaoType value : values()) {
            if (value.name().equalsIgnoreCase(type)) {
                return type;
            }
        }
        throw new IllegalArgumentException(type);
    }
}
