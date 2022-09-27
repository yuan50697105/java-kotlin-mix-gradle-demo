package com.example.demo.dao;

import com.example.demo.entity.JavaSystemPermission;
import com.example.demo.entity.dto.JavaSystemPermissionWrapper;
import com.example.demo.entity.dto.Pagination;

import java.util.Collection;
import java.util.List;

public interface JavaSystemPermissionDao {
    String getType();

    void saveData(JavaSystemPermission javaSystemRole);

    void updateData(JavaSystemPermission javaSystemRole);

    JavaSystemPermission get(Long id);

    void deleteData(Long[] ids);

    void deleteData(Collection<Long> ids);

    void deleteData(Long id, Long... ids);

    List<JavaSystemPermission> getList(JavaSystemPermissionWrapper wrapper);

    List<JavaSystemPermission> getList(JavaSystemPermissionWrapper wrapper, int page, int size);

    Pagination<JavaSystemPermission> getPage(JavaSystemPermissionWrapper wrapper, int page, int size);
}
