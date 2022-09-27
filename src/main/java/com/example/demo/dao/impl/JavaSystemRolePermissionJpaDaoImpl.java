package com.example.demo.dao.impl;

import com.example.demo.constants.JavaDaoType;
import com.example.demo.dao.JavaSystemRolePermissionDao;
import com.example.demo.entity.JavaSystemRolePermission;
import com.example.demo.repository.JavaSystemRolePermissionRepository;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class JavaSystemRolePermissionJpaDaoImpl implements JavaSystemRolePermissionDao {
    private final JavaSystemRolePermissionRepository repository;

    public JavaSystemRolePermissionJpaDaoImpl(JavaSystemRolePermissionRepository repository) {
        this.repository = repository;
    }

    @Override
    public String getType() {
        return JavaDaoType.JPA.name();
    }

    @Override
    @Transactional
    public void saveData(JavaSystemRolePermission javaSystemUser) {
        repository.save(javaSystemUser);
    }

    @Override
    public void updateData(JavaSystemRolePermission javaSystemUser) {
        repository.save(javaSystemUser);
    }

    @Override
    public JavaSystemRolePermission get(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void deleteData(Long[] ids) {
        this.deleteData(Arrays.asList(ids));
    }

    @Override
    @Transactional
    public void deleteData(Collection<Long> ids) {
        repository.deleteAllById(ids);
    }

    @Override
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
        this.repository.saveAll(javaSystemRolePermissions);
    }

    @Override
    @Transactional
    public void updateData(Long roleId, List<Long> permissionIds) {
        this.repository.deleteByRoleId(roleId);
        ArrayList<JavaSystemRolePermission> entities = new ArrayList<>(permissionIds.size());
        for (Long permissionId : permissionIds) {
            entities.add(new JavaSystemRolePermission(roleId, permissionId));
        }
        this.repository.saveAll(entities);
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
        this.repository.deleteByRoleIdIn(roleIds);
    }

    @Override
    @Transactional
    public void deleteDataByPermissionIds(Long permissionId, Long... permissionIds) {
        this.deleteDataByPermissionIds(Lists.asList(permissionId, permissionIds));
    }

    @Override
    @Transactional
    public void deleteDataByPermissionIds(Long[] permissionIds) {
        this.deleteDataByPermissionIds(Arrays.asList(permissionIds));
    }

    @Override
    @Transactional
    public void deleteDataByPermissionIds(List<Long> permissionIds) {
        this.repository.deleteByPermissionIdIn(permissionIds);
    }
}
