package com.example.demo.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.example.demo.dao.JavaTableDao;
import com.example.demo.entity.JavaTable;
import com.example.demo.service.JavaTableDaoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class JavaTableDaoFactoryImpl implements JavaTableDaoFactory {
    private final Map<String, JavaTableDao> javaTableDaoMap;

    @Autowired
    public JavaTableDaoFactoryImpl(List<JavaTableDao> javaTableDao) {
        this.javaTableDaoMap = javaTableDao.stream().collect(Collectors.toMap(JavaTableDao::getType, Function.identity()));
    }


    @Override
    public void saveData(JavaTable data, String type) {
        JavaTableDao javaTableDao = javaTableDaoMap.get(DaoType.getType(type));
        if (ObjectUtil.isNotEmpty(javaTableDao)) {
            javaTableDao.saveData(data);
        } else {
            throw new IllegalArgumentException(type);
        }
    }


}
