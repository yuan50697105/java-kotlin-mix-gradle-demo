package com.example.demo.dao.factory.impl;

import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.ObjectUtil;
import com.example.demo.constants.JavaDaoType;
import com.example.demo.dao.api.JavaSystemRolePermissionDao;
import com.example.demo.dao.factory.JavaSystemRolePermissionDaoFactory;
import com.example.demo.entity.JavaSystemRolePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public void saveData(String type, JavaSystemRolePermission javaSystemUser) {
        getJavaSystemRolePermissionDao(type).saveData(javaSystemUser);

    }

    @Override
    @Transactional
    public void updateData(String type, JavaSystemRolePermission javaSystemUser) {
        getJavaSystemRolePermissionDao(type).updateData(javaSystemUser);
    }

    @Override
    public JavaSystemRolePermission get(String type, Long id) {
        return getJavaSystemRolePermissionDao(type).get(id);
    }

    @Override
    @Transactional
    public void deleteData(String type, Long[] ids) {
        getJavaSystemRolePermissionDao(type).deleteData(ids);
    }

    @Override
    @Transactional
    public void deleteData(String type, Collection<Long> ids) {
        getJavaSystemRolePermissionDao(type).deleteData(ids);
    }

    @Override
    @Transactional
    public void deleteData(String type, Long id, Long... ids) {
        getJavaSystemRolePermissionDao(type).deleteData(ids);
    }

    @Override
    @Transactional
    public void saveData(String type, Long roleId, List<Long> permissionIds) {
        if (ObjectUtil.isAllNotEmpty(roleId, permissionIds)) {
            getJavaSystemRolePermissionDao(type).saveData(roleId, permissionIds);
        }
    }

    @Override
    @Transactional
    public void updateData(String type, Long roleId, List<Long> permissionIds) {
        if (ObjectUtil.isAllNotEmpty(roleId, permissionIds)) {
            getJavaSystemRolePermissionDao(type).updateData(roleId, permissionIds);
        }
    }

    @Override
    @Transactional
    public void deleteDataByRoleIds(String type, Long[] roleIds) {
        getJavaSystemRolePermissionDao(type).deleteDataByRoleIds(roleIds);
    }

    @Override
    @Transactional
    public void deleteDataByRoleIds(String type, Long roleId, Long... roleIds) {
        getJavaSystemRolePermissionDao(type).deleteDataByRoleIds(roleId, roleIds);
    }

    @Override
    @Transactional
    public void deleteDataByRoleIds(String type, List<Long> roleIds) {
        getJavaSystemRolePermissionDao(type).deleteDataByRoleIds(roleIds);
    }

    @Override
    @Transactional
    public void deleteDataByPermissionIds(String type, Long permissionId, Long... permissionIds) {
        getJavaSystemRolePermissionDao(type).deleteDataByPermissionIds(permissionId, permissionIds);
    }

    @Override
    @Transactional
    public void deleteDataByPermissionIds(String type, Long[] permissionIds) {
        getJavaSystemRolePermissionDao(type).deleteDataByPermissionIds(permissionIds);
    }

    @Override
    @Transactional
    public void deleteDataByPermissionIds(String type, List<Long> permissionIds) {
        getJavaSystemRolePermissionDao(type).deleteDataByPermissionIds(permissionIds);
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
