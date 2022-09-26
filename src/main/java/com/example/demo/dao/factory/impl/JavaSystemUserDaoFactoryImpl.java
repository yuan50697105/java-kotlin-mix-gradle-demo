package com.example.demo.dao.factory.impl;

import cn.hutool.core.util.ObjUtil;
import com.example.demo.constants.JavaDaoType;
import com.example.demo.dao.JavaSystemUserDao;
import com.example.demo.dao.factory.JavaSystemUserDaoFactory;
import com.example.demo.entity.JavaSystemUser;
import com.example.demo.entity.dto.JavaSystemUserWrapper;
import com.example.demo.entity.dto.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class JavaSystemUserDaoFactoryImpl implements JavaSystemUserDaoFactory {
    private final Map<String, JavaSystemUserDao> daoMap;

    @Autowired
    public JavaSystemUserDaoFactoryImpl(List<JavaSystemUserDao> systemUserDaoList) {
        this.daoMap = systemUserDaoList.stream().collect(Collectors.toMap(JavaSystemUserDao::getType, Function.identity()));
    }

    @Override
    public void saveData(String type, JavaSystemUser javaSystemUser) {
        getJavaSystemUserDao(type).saveData(javaSystemUser);

    }

    @Override
    public void updateData(String type, JavaSystemUser javaSystemUser) {
        getJavaSystemUserDao(type).updateData(javaSystemUser);
    }

    @Override
    public JavaSystemUser get(String type, Long id) {
        return getJavaSystemUserDao(type).get(id);
    }

    @Override
    public void deleteData(String type, Long[] ids) {
        getJavaSystemUserDao(type).deleteData(ids);
    }

    @Override
    public void deleteData(String type, Collection<Long> ids) {
        getJavaSystemUserDao(type).deleteData(ids);
    }

    @Override
    public void deleteData(String type, Long id, Long... ids) {
        getJavaSystemUserDao(type).deleteData(ids);
    }

    @Override
    public List<JavaSystemUser> getList(String type, JavaSystemUserWrapper javaSystemUser) {
        return getJavaSystemUserDao(type).getList(javaSystemUser);
    }

    @Override
    public List<JavaSystemUser> getList(String type, JavaSystemUserWrapper javaSystemUser, int page, int size) {
        return getJavaSystemUserDao(type).getList(javaSystemUser, page, size);
    }

    @Override
    public Pagination<JavaSystemUser> getPage(String type, JavaSystemUserWrapper javaSystemUser, int page, int size) {
        return getJavaSystemUserDao(type).getPage(javaSystemUser, page, size);
    }

    private JavaSystemUserDao getJavaSystemUserDao(String type) {
        JavaSystemUserDao javaSystemUserDao = daoMap.get(JavaDaoType.getType(type));
        if (ObjUtil.isNotEmpty(javaSystemUserDao)) {
            return javaSystemUserDao;
        } else {
            throw new IllegalArgumentException(type);
        }
    }
}
