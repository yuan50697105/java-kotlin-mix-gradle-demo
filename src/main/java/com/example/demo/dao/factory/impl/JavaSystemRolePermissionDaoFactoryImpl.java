package com.example.demo.dao.factory.impl;

import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.ObjectUtil;
import com.example.demo.constants.JavaDaoType;
import com.example.demo.dao.JavaSystemRolePermissionDao;
import com.example.demo.dao.factory.JavaSystemRolePermissionDaoFactory;
import com.example.demo.entity.JavaSystemRolePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class JavaSystemRolePermissionDaoFactoryImpl implements JavaSystemRolePermissionDaoFactory {
    private final Map<String, JavaSystemRolePermissionDao> daoMap;

    @Autowired
    public JavaSystemRolePermissionDaoFactoryImpl(List<JavaSystemRolePermissionDao> systemUserDaoList) {
        this.daoMap = systemUserDaoList.stream().collect(Collectors.toMap(JavaSystemRolePermissionDao::getType, Function.identity()));
    }

    @Override
    public void saveData(String type, JavaSystemRolePermission javaSystemUser) {
        getJavaSystemRolePermissionDao(type).saveData(javaSystemUser);

    }

    @Override
    public void updateData(String type, JavaSystemRolePermission javaSystemUser) {
        getJavaSystemRolePermissionDao(type).updateData(javaSystemUser);
    }

    @Override
    public JavaSystemRolePermission get(String type, Long id) {
        return getJavaSystemRolePermissionDao(type).get(id);
    }

    @Override
    public void deleteData(String type, Long[] ids) {
        getJavaSystemRolePermissionDao(type).deleteData(ids);
    }

    @Override
    public void deleteData(String type, Collection<Long> ids) {
        getJavaSystemRolePermissionDao(type).deleteData(ids);
    }

    @Override
    public void deleteData(String type, Long id, Long... ids) {
        getJavaSystemRolePermissionDao(type).deleteData(ids);
    }

    @Override
    public void saveData(String type, Long roleId, List<Long> permissionIds) {
        if (ObjectUtil.isAllNotEmpty(roleId, permissionIds)) {
            getJavaSystemRolePermissionDao(type).saveData(roleId, permissionIds);
        }
    }

    @Override
    public void updateData(String type, Long roleId, List<Long> permissionIds) {
        if (ObjectUtil.isAllNotEmpty(roleId, permissionIds)) {
            getJavaSystemRolePermissionDao(type).updateData(roleId, permissionIds);
        }
    }

    private JavaSystemRolePermissionDao getJavaSystemRolePermissionDao(String type) {
        JavaSystemRolePermissionDao javaSystemUserDao = daoMap.get(JavaDaoType.getType(type));
        if (ObjUtil.isNotEmpty(javaSystemUserDao)) {
            return javaSystemUserDao;
        } else {
            throw new IllegalArgumentException(type);
        }
    }
}
