package com.example.demo.dao.factory.impl;

import cn.hutool.core.util.ObjectUtil;
import com.example.demo.constants.JavaDaoType;
import com.example.demo.dao.api.JavaTableDao;
import com.example.demo.dao.factory.JavaTableDaoFactory;
import com.example.demo.entity.JavaTable;
import com.example.demo.entity.dto.JavaTableWrapper;
import com.example.demo.entity.dto.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    private JavaTableDao getJavaTableDao(String type) {
        return javaTableDaoMap.get(type);
    }


    @Override
    @Transactional
    public void saveData(JavaTable data, String type) {
        JavaTableDao javaTableDao = getJavaTableDao(JavaDaoType.getType(type));
        if (ObjectUtil.isNotEmpty(javaTableDao)) {
            javaTableDao.saveData(data);
        } else {
            throw new IllegalArgumentException(type);
        }
    }

    @Override
    @Transactional
    public void updateData(JavaTable javaTable, String type) {
        getJavaTableDao(type).updateData(javaTable);
    }

    @Override
    public JavaTable get(Long id, String type) {
        JavaTableDao javaTableDao = getJavaTableDao(type);
        return javaTableDao.get(id);
    }

    @Override
    public List<JavaTable> getList(JavaTableWrapper wrapper, String type) {
        return getJavaTableDao(type).getList(wrapper);
    }

    @Override
    public Pagination<JavaTable> getPage(JavaTableWrapper wrapper, int page, int size, String type) {
        return getJavaTableDao(type).getPage(wrapper, page, size);
    }

    @Override
    @Transactional
    public void deleteData(Long[] id, String type) {
        getJavaTableDao(type).deleteData(id);
    }


}
