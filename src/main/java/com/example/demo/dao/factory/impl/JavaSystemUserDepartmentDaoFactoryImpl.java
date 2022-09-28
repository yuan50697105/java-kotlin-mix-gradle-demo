package com.example.demo.dao.factory.impl;

import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.ObjectUtil;
import com.example.demo.constants.JavaDaoType;
import com.example.demo.dao.JavaSystemUserDepartmentDao;
import com.example.demo.dao.factory.JavaSystemUserDepartmentDaoFactory;
import com.example.demo.entity.JavaSystemUserDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class JavaSystemUserDepartmentDaoFactoryImpl implements JavaSystemUserDepartmentDaoFactory {
    private final Map<String, JavaSystemUserDepartmentDao> daoMap;

    @Autowired
    public JavaSystemUserDepartmentDaoFactoryImpl(List<JavaSystemUserDepartmentDao> systemUserDaoList) {
        this.daoMap = systemUserDaoList.stream().collect(Collectors.toMap(JavaSystemUserDepartmentDao::getType, Function.identity()));
    }

    @Override
    @Transactional
    public void saveData(String type, JavaSystemUserDepartment javaSystemUser) {
        getJavaSystemUserDepartmentDao(type).saveData(javaSystemUser);

    }

    @Override
    @Transactional
    public void updateData(String type, JavaSystemUserDepartment javaSystemUser) {
        getJavaSystemUserDepartmentDao(type).updateData(javaSystemUser);
    }

    @Override
    public JavaSystemUserDepartment get(String type, Long id) {
        return getJavaSystemUserDepartmentDao(type).get(id);
    }

    @Override
    @Transactional
    public void deleteData(String type, Long[] ids) {
        getJavaSystemUserDepartmentDao(type).deleteData(ids);
    }

    @Override
    @Transactional
    public void deleteData(String type, Collection<Long> ids) {
        getJavaSystemUserDepartmentDao(type).deleteData(ids);
    }

    @Override
    @Transactional
    public void deleteData(String type, Long id, Long... ids) {
        getJavaSystemUserDepartmentDao(type).deleteData(ids);
    }

    @Override
    public void saveData(String type, Long userId, List<Long> departIds) {
        if (ObjectUtil.isAllNotEmpty(userId, departIds)) {
            this.getJavaSystemUserDepartmentDao(type).saveData(userId, departIds);

        }
    }

    @Override
    public void updateData(String type, Long userId, List<Long> departIds) {
        if (ObjectUtil.isAllNotEmpty(userId, departIds)) {
            getJavaSystemUserDepartmentDao(type).updateData(userId, departIds);
        }
    }

    @Override
    @Transactional
    public void deleteDataByUserIds(String type, Long[] userIds) {
        getJavaSystemUserDepartmentDao(type).deleteDataByUserIds(userIds);
    }

    @Override
    public void deleteDataByDepartIds(String type, Long[] departIds) {
        getJavaSystemUserDepartmentDao(type).deleteDataByDepartIds(departIds);
    }


    private JavaSystemUserDepartmentDao getJavaSystemUserDepartmentDao(String type) {
        JavaSystemUserDepartmentDao javaSystemUserDao = daoMap.get(JavaDaoType.getType(type));
        if (ObjUtil.isNotEmpty(javaSystemUserDao)) {
            return javaSystemUserDao;
        } else {
            throw new IllegalArgumentException(type);
        }
    }
}
