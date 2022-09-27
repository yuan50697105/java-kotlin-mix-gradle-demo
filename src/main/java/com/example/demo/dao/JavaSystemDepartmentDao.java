package com.example.demo.dao;

import com.example.demo.entity.JavaSystemDepartment;
import com.example.demo.entity.dto.JavaSystemDepartmentWrapper;
import com.example.demo.entity.dto.Pagination;

import java.util.Collection;
import java.util.List;

public interface JavaSystemDepartmentDao {
    String getType();

    void saveData(JavaSystemDepartment javaSystemRole);

    void updateData(JavaSystemDepartment javaSystemRole);

    JavaSystemDepartment get(Long id);

    void deleteData(Long[] ids);

    void deleteData(Collection<Long> ids);

    void deleteData(Long id, Long... ids);

    List<JavaSystemDepartment> getList(JavaSystemDepartmentWrapper wrapper);

    List<JavaSystemDepartment> getList(JavaSystemDepartmentWrapper wrapper, int page, int size);

    Pagination<JavaSystemDepartment> getPage(JavaSystemDepartmentWrapper wrapper, int page, int size);
}
