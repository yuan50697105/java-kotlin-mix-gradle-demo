package com.example.demo.dao.impl;

import cn.org.atool.fluent.mybatis.base.IBaseDao;
import com.example.demo.constants.JavaDaoType;
import com.example.demo.dao.JavaSystemRolePermissionDao;
import com.example.demo.dao.base.JavaSystemRolePermissionBaseDao;
import com.example.demo.entity.JavaSystemRolePermission;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class JavaSystemRolePermissionFluentDaoImpl extends JavaSystemRolePermissionBaseDao implements JavaSystemRolePermissionDao, IBaseDao<JavaSystemRolePermission> {
    @Override
    public String getType() {
        return JavaDaoType.FLUENT.name();
    }

    @Override
    @Transactional
    public void saveData(JavaSystemRolePermission javaSystemUser) {
        this.save(javaSystemUser);
    }

    @Override
    @Transactional
    public void updateData(JavaSystemRolePermission javaSystemUser) {
        this.updateById(javaSystemUser);
    }

    @Override
    public JavaSystemRolePermission get(Long id) {
        return this.selectById(id);
    }

    @Override
    @Transactional
    public void deleteData(Long[] ids) {
        this.deleteByIds(Arrays.asList(ids));
    }

    @Override
    @Transactional
    public void deleteData(Collection<Long> ids) {
        this.deleteByIds(ids);
    }

    @Override
    @Transactional
    public void deleteData(Long id, Long... ids) {
        this.deleteData(Lists.asList(id, ids));
    }

    @Override
    @Transactional
    public void saveData(Long roleId, List<Long> permissionIds) {
        ArrayList<JavaSystemRolePermission> list = new ArrayList<>(permissionIds.size());
        for (Long permissionId : permissionIds) {
            list.add(new JavaSystemRolePermission(roleId, permissionId));
        }
        this.save(list);
    }

    @Override
    @Transactional
    public void saveData(List<JavaSystemRolePermission> javaSystemRolePermissions) {
        this.save(javaSystemRolePermissions);
    }

    @Override
    @Transactional
    public void updateData(Long roleId, List<Long> permissionIds) {
        deleteBy(query().where.roleId().eq(roleId).end());
        ArrayList<JavaSystemRolePermission> list = new ArrayList<>(permissionIds.size());
        for (Long permissionId : permissionIds) {
            list.add(new JavaSystemRolePermission(roleId, permissionId));
        }
        save(list);
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
        deleteBy(query().where.roleId().in(roleIds).end());
    }
}
