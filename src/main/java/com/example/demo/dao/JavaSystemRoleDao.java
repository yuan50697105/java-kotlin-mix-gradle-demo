package com.example.demo.dao;

import com.example.demo.entity.JavaSystemRole;
import com.example.demo.entity.dto.JavaSystemRoleWrapper;
import com.example.demo.entity.dto.Pagination;

import java.util.Collection;
import java.util.List;

public interface JavaSystemRoleDao {
    String getType();

    void saveData(JavaSystemRole javaSystemRole);

    void updateData(JavaSystemRole javaSystemRole);

    JavaSystemRole get(Long id);

    void deleteData(Long[] ids);

    void deleteData(Collection<Long> ids);

    void deleteData(Long id, Long... ids);

    List<JavaSystemRole> getList(JavaSystemRoleWrapper wrapper);

    List<JavaSystemRole> getList(JavaSystemRoleWrapper wrapper, int page, int size);

    Pagination<JavaSystemRole> getPage(JavaSystemRoleWrapper wrapper, int page, int size);
}
