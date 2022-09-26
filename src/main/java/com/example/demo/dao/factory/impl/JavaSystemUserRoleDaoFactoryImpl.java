package com.example.demo.dao.factory.impl;

import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.ObjectUtil;
import com.example.demo.constants.JavaDaoType;
import com.example.demo.dao.JavaSystemUserRoleDao;
import com.example.demo.dao.factory.JavaSystemUserRoleDaoFactory;
import com.example.demo.entity.JavaSystemUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class JavaSystemUserRoleDaoFactoryImpl implements JavaSystemUserRoleDaoFactory {
    private final Map<String, JavaSystemUserRoleDao> daoMap;

    @Autowired
    public JavaSystemUserRoleDaoFactoryImpl(List<JavaSystemUserRoleDao> systemUserDaoList) {
        this.daoMap = systemUserDaoList.stream().collect(Collectors.toMap(JavaSystemUserRoleDao::getType, Function.identity()));
    }

    @Override
    @Transactional
    public void saveData(String type, JavaSystemUserRole javaSystemUser) {
        getJavaSystemUserRoleDao(type).saveData(javaSystemUser);
    }

    @Override
    @Transactional
    public void saveData(String type, List<JavaSystemUserRole> javaSystemUser) {
        getJavaSystemUserRoleDao(type).saveData(javaSystemUser);
    }

    @Override
    public void updateData(String type, Long userId, List<Long> roleIds) {
        if (ObjectUtil.isAllNotEmpty(userId, roleIds)) {
            getJavaSystemUserRoleDao(type).deleteDataByUserIds(roleIds);
            List<JavaSystemUserRole> javaSystemUserRoles = new ArrayList<>();
            getJavaSystemUserRoleDao(type).updateData(javaSystemUserRoles);
        }
    }

    @Override
    public JavaSystemUserRole get(String type, Long id) {
        return getJavaSystemUserRoleDao(type).get(id);
    }

    @Override
    public void deleteData(String type, Long[] ids) {
        getJavaSystemUserRoleDao(type).deleteData(ids);
    }

    @Override
    public void deleteData(String type, Collection<Long> ids) {
        getJavaSystemUserRoleDao(type).deleteData(ids);
    }

    @Override
    public void deleteData(String type, Long id, Long... ids) {
        getJavaSystemUserRoleDao(type).deleteData(ids);
    }

    @Override
    public void saveData(String type, Long userId, List<Long> roleIds) {
        if (ObjectUtil.isAllNotEmpty(userId, roleIds)) {
            List<JavaSystemUserRole> javaSystemUserRoles = new ArrayList<>();
            for (Long roleId : roleIds) {
                javaSystemUserRoles.add(new JavaSystemUserRole(userId, roleId));
            }
            this.saveData(type, javaSystemUserRoles);
        }
    }

    @Override
    @Transactional
    public void deleteDataByUserIds(String type, Long[] userIds) {
        getJavaSystemUserRoleDao(type).deleteDataByUserIds(userIds);
    }

    @Override
    @Transactional
    public void deleteDataByRoleIds(String type, Long[] roleIds) {
        getJavaSystemUserRoleDao(type).deleteDataByRoleIds(roleIds);
    }

    private JavaSystemUserRoleDao getJavaSystemUserRoleDao(String type) {
        JavaSystemUserRoleDao javaSystemUserDao = daoMap.get(JavaDaoType.getType(type));
        if (ObjUtil.isNotEmpty(javaSystemUserDao)) {
            return javaSystemUserDao;
        } else {
            throw new IllegalArgumentException(type);
        }
    }
}
