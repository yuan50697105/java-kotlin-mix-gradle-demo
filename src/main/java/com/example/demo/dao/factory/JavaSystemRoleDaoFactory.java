package com.example.demo.dao.factory;

import com.example.demo.entity.JavaSystemRole;
import com.example.demo.entity.dto.JavaSystemRoleWrapper;
import com.example.demo.entity.dto.Pagination;

import java.util.Collection;
import java.util.List;

public interface JavaSystemRoleDaoFactory {

    void saveData(String type, JavaSystemRole javaSystemUser);

    void updateData(String type, JavaSystemRole javaSystemUser);

    JavaSystemRole get(String type, Long id);

    void deleteData(String type, Long[] ids);

    void deleteData(String type, Collection<Long> ids);

    void deleteData(String type, Long id, Long... ids);

    List<JavaSystemRole> getList(String type, JavaSystemRoleWrapper javaSystemUser);

    List<JavaSystemRole> getList(String type, JavaSystemRoleWrapper javaSystemUser, int page, int size);

    Pagination<JavaSystemRole> getPage(String type, JavaSystemRoleWrapper javaSystemUser, int page, int size);
}
