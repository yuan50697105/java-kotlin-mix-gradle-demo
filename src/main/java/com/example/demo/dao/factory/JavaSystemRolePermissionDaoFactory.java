package com.example.demo.dao.factory;

import com.example.demo.entity.JavaSystemRolePermission;

import java.util.Collection;
import java.util.List;

public interface JavaSystemRolePermissionDaoFactory {

    void saveData(String type, JavaSystemRolePermission data);

    void updateData(String type, JavaSystemRolePermission data);

    JavaSystemRolePermission get(String type, Long id);

    void deleteData(String type, Long[] ids);

    void deleteData(String type, Collection<Long> ids);

    void deleteData(String type, Long id, Long... ids);

    void saveData(String type, Long roleId, List<Long> permissionIds);

    void updateData(String type, Long roleId, List<Long> permissionIds);

    void deleteDataByRoleIds(String type, Long[] roleIds);

    void deleteDataByRoleIds(String type, Long id, Long... roleIds);

    void deleteDataByRoleIds(String type, List<Long> roleIds);

    void deleteDataByPermissionIds(String type, String permissionId, Long... permissionIds);

    void deleteDataByPermissionIds(String type, Long[] permissionIds);

    void deleteDataByPermissionIds(String type, List<Long> permissionIds);
}
