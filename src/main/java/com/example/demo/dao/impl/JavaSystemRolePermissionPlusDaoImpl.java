package com.example.demo.dao.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.constants.JavaDaoType;
import com.example.demo.dao.JavaSystemRolePermissionDao;
import com.example.demo.entity.JavaSystemRolePermission;
import com.example.demo.mapper.JavaSystemRolePermissionDaoMapper;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class JavaSystemRolePermissionPlusDaoImpl extends ServiceImpl<JavaSystemRolePermissionDaoMapper, JavaSystemRolePermission> implements JavaSystemRolePermissionDao, IService<JavaSystemRolePermission> {
    @Override
    public String getType() {
        return JavaDaoType.PLUS.name();
    }

    @Override
    @Transactional
    public void saveData(JavaSystemRolePermission javaSystemUser) {
        this.save(javaSystemUser);
    }

    @Override
    @Transactional
    public void updateData(JavaSystemRolePermission javaSystemUser) {
        this.updateData(javaSystemUser);
    }

    @Override
    public JavaSystemRolePermission get(Long id) {
        return getById(id);
    }

    @Override
    @Transactional
    public void deleteData(Long[] ids) {
        this.deleteData(Arrays.asList(ids));
    }

    @Override
    @Transactional
    public void deleteData(Collection<Long> ids) {
        removeByIds(ids);
    }

    @Override
    @Transactional
    public void deleteData(Long id, Long... ids) {
        this.deleteData(Lists.asList(id, ids));
    }

    @Override
    @Transactional
    public void saveData(Long roleId, List<Long> permissionIds) {
        ArrayList<JavaSystemRolePermission> javaSystemRolePermissions = new ArrayList<>(permissionIds.size());
        for (Long permissionId : permissionIds) {
            javaSystemRolePermissions.add(new JavaSystemRolePermission(roleId, permissionId));
        }
        this.saveData(javaSystemRolePermissions);
    }

    @Override
    @Transactional
    public void saveData(List<JavaSystemRolePermission> javaSystemRolePermissions) {
        this.saveBatch(javaSystemRolePermissions);
    }

    @Override
    @Transactional
    public void updateData(Long roleId, List<Long> permissionIds) {
        lambdaUpdate().eq(JavaSystemRolePermission::getRoleId, roleId).remove();
        ArrayList<JavaSystemRolePermission> entityList = new ArrayList<>(permissionIds.size());
        for (Long permissionId : permissionIds) {
            entityList.add(new JavaSystemRolePermission(roleId, permissionId));
        }
        this.saveBatch(entityList);
    }

    @Override
    @Transactional
    public void deleteDataByRoleIds(Long roleId, Long... roleIds) {
        this.deleteDataByRoleIds(Lists.asList(roleId, roleIds));
    }

    @Override
    @Transactional
    public void deleteDataByRoleIds(Long[] roleIds) {
        this.deleteDataByRoleIds(Arrays.asList(roleIds));
    }

    @Override
    @Transactional
    public void deleteDataByRoleIds(List<Long> roleIds) {
        lambdaUpdate().in(JavaSystemRolePermission::getRoleId, roleIds).remove();
    }
}
