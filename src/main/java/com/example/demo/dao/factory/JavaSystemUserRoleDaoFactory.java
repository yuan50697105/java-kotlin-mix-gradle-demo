package com.example.demo.dao.factory;

import com.example.demo.entity.JavaSystemUserRole;

import java.util.Collection;
import java.util.List;

public interface JavaSystemUserRoleDaoFactory {

    void saveData(String type, JavaSystemUserRole javaSystemUser);

    void saveData(String type, List<JavaSystemUserRole> javaSystemUser);

    void updateData(String type, Long userId, List<Long> roleIds);

    JavaSystemUserRole get(String type, Long id);

    void deleteData(String type, Long[] ids);

    void deleteData(String type, Collection<Long> ids);

    void deleteData(String type, Long id, Long... ids);

    void saveData(String type, Long userId, List<Long> roleIds);

    void deleteDataByUserIds(String type, Long[] userIds);

    void deleteDataByRoleIds(String type, Long[] roleIds);
}
