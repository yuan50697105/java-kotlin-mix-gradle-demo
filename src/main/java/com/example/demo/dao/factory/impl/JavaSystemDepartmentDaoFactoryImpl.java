package com.example.demo.dao.factory.impl;

import cn.hutool.core.util.ObjUtil;
import com.example.demo.constants.JavaDaoType;
import com.example.demo.dao.JavaSystemDepartmentDao;
import com.example.demo.dao.factory.JavaSystemDepartmentDaoFactory;
import com.example.demo.entity.JavaSystemDepartment;
import com.example.demo.entity.dto.JavaSystemDepartmentWrapper;
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
public class JavaSystemDepartmentDaoFactoryImpl implements JavaSystemDepartmentDaoFactory {
    private final Map<String, JavaSystemDepartmentDao> daoMap;

    @Autowired
    public JavaSystemDepartmentDaoFactoryImpl(List<JavaSystemDepartmentDao> systemUserDaoList) {
        this.daoMap = systemUserDaoList.stream().collect(Collectors.toMap(JavaSystemDepartmentDao::getType, Function.identity()));
    }

    @Override
    @Transactional
    public void saveData(String type, JavaSystemDepartment javaSystemUser) {
        getJavaSystemDepartmentDao(type).saveData(javaSystemUser);

    }

    @Override
    @Transactional
    public void updateData(String type, JavaSystemDepartment javaSystemUser) {
        getJavaSystemDepartmentDao(type).updateData(javaSystemUser);
    }

    @Override
    public JavaSystemDepartment get(String type, Long id) {
        return getJavaSystemDepartmentDao(type).get(id);
    }

    @Override
    @Transactional
    public void deleteData(String type, Long[] ids) {
        getJavaSystemDepartmentDao(type).deleteData(ids);
    }

    @Override
    @Transactional
    public void deleteData(String type, Collection<Long> ids) {
        getJavaSystemDepartmentDao(type).deleteData(ids);
    }

    @Override
    @Transactional
    public void deleteData(String type, Long id, Long... ids) {
        getJavaSystemDepartmentDao(type).deleteData(ids);
    }

    @Override
    public List<JavaSystemDepartment> getList(String type, JavaSystemDepartmentWrapper javaSystemUser) {
        return getJavaSystemDepartmentDao(type).getList(javaSystemUser);
    }

    @Override
    public List<JavaSystemDepartment> getList(String type, JavaSystemDepartmentWrapper javaSystemUser, int page, int size) {
        return getJavaSystemDepartmentDao(type).getList(javaSystemUser, page, size);
    }

    @Override
    public Pagination<JavaSystemDepartment> getPage(String type, JavaSystemDepartmentWrapper javaSystemUser, int page, int size) {
        return getJavaSystemDepartmentDao(type).getPage(javaSystemUser, page, size);
    }

    private JavaSystemDepartmentDao getJavaSystemDepartmentDao(String type) {
        JavaSystemDepartmentDao javaSystemUserDao = daoMap.get(JavaDaoType.getType(type));
        if (ObjUtil.isNotEmpty(javaSystemUserDao)) {
            return javaSystemUserDao;
        } else {
            throw new IllegalArgumentException(type);
        }
    }
}
