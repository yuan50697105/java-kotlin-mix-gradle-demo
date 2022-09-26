package com.example.demo.dao;

import com.example.demo.entity.JavaSystemUserRole;

import java.util.Collection;
import java.util.List;

public interface JavaSystemUserRoleDao {
    String getType();

    void saveData(JavaSystemUserRole javaSystemRole);

    void saveData(List<JavaSystemUserRole> javaSystemUser);

    void updateData(JavaSystemUserRole javaSystemRole);

    JavaSystemUserRole get(Long id);

    void deleteData(Long[] ids);

    void deleteData(Collection<Long> ids);

    void deleteData(Long id, Long... ids);

    void updateData(List<JavaSystemUserRole> javaSystemUserRoles);

    void deleteDataByUserIds(Long userId, Long[] userIds);

    void deleteDataByUserIds(Long[] userIds);

    void deleteDataByUserIds(List<Long> userIds);

    void deleteDataByRoleIds(Long roleId, Long[] roleIds);

    void deleteDataByRoleIds(Long[] roleIds);

    void deleteDataByRoleIds(List<Long> roleIds);
}
