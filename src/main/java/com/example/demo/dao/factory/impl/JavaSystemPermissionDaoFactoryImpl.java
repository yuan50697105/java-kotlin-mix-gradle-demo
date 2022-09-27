package com.example.demo.dao.factory.impl;

import cn.hutool.core.util.ObjUtil;
import com.example.demo.constants.JavaDaoType;
import com.example.demo.dao.JavaSystemPermissionDao;
import com.example.demo.dao.factory.JavaSystemPermissionDaoFactory;
import com.example.demo.entity.JavaSystemPermission;
import com.example.demo.entity.dto.JavaSystemPermissionWrapper;
import com.example.demo.entity.dto.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class JavaSystemPermissionDaoFactoryImpl implements JavaSystemPermissionDaoFactory {
    private final Map<String, JavaSystemPermissionDao> daoMap;

    @Autowired
    public JavaSystemPermissionDaoFactoryImpl(List<JavaSystemPermissionDao> systemUserDaoList) {
        this.daoMap = systemUserDaoList.stream().collect(Collectors.toMap(JavaSystemPermissionDao::getType, Function.identity()));
    }

    @Override
    @Transactional
    public void saveData(String type, JavaSystemPermission javaSystemUser) {
        getJavaSystemPermissionDao(type).saveData(javaSystemUser);

    }

    @Override
    @Transactional
    public void updateData(String type, JavaSystemPermission javaSystemUser) {
        getJavaSystemPermissionDao(type).updateData(javaSystemUser);
    }

    @Override
    public JavaSystemPermission get(String type, Long id) {
        return getJavaSystemPermissionDao(type).get(id);
    }

    @Override
    @Transactional
    public void deleteData(String type, Long[] ids) {
        getJavaSystemPermissionDao(type).deleteData(ids);
    }

    @Override
    @Transactional
    public void deleteData(String type, Collection<Long> ids) {
        getJavaSystemPermissionDao(type).deleteData(ids);
    }

    @Override
    @Transactional
    public void deleteData(String type, Long id, Long... ids) {
        getJavaSystemPermissionDao(type).deleteData(ids);
    }

    @Override
    public List<JavaSystemPermission> getList(String type, JavaSystemPermissionWrapper javaSystemUser) {
        return getJavaSystemPermissionDao(type).getList(javaSystemUser);
    }

    @Override
    public List<JavaSystemPermission> getList(String type, JavaSystemPermissionWrapper javaSystemUser, int page, int size) {
        return getJavaSystemPermissionDao(type).getList(javaSystemUser, page, size);
    }

    @Override
    public Pagination<JavaSystemPermission> getPage(String type, JavaSystemPermissionWrapper javaSystemUser, int page, int size) {
        return getJavaSystemPermissionDao(type).getPage(javaSystemUser, page, size);
    }

    private JavaSystemPermissionDao getJavaSystemPermissionDao(String type) {
        JavaSystemPermissionDao javaSystemUserDao = daoMap.get(JavaDaoType.getType(type));
        if (ObjUtil.isNotEmpty(javaSystemUserDao)) {
            return javaSystemUserDao;
        } else {
            throw new IllegalArgumentException(type);
        }
    }
}
