package com.example.demo.dao;

import com.example.demo.entity.JavaSystemRolePermission;

import java.util.Collection;
import java.util.List;

public interface JavaSystemRolePermissionDao {
    String getType();

    void saveData(JavaSystemRolePermission javaSystemRole);

    void updateData(JavaSystemRolePermission javaSystemRole);

    JavaSystemRolePermission get(Long id);

    void deleteData(Long[] ids);

    void deleteData(Collection<Long> ids);

    void deleteData(Long id, Long... ids);

    void saveData(Long roleId, List<Long> permissionIds);

    void saveData(List<JavaSystemRolePermission> javaSystemRolePermissions);

    void updateData(Long roleId, List<Long> permissionIds);
}
