package com.example.demo.dao.factory;

import com.example.demo.entity.JavaSystemDepartment;
import com.example.demo.entity.dto.JavaSystemDepartmentWrapper;
import com.example.demo.entity.dto.Pagination;

import java.util.Collection;
import java.util.List;

public interface JavaSystemDepartmentDaoFactory {

    void saveData(String type, JavaSystemDepartment data);

    void updateData(String type, JavaSystemDepartment data);

    JavaSystemDepartment get(String type, Long id);

    void deleteData(String type, Long[] ids);

    void deleteData(String type, Collection<Long> ids);

    void deleteData(String type, Long id, Long... ids);

    List<JavaSystemDepartment> getList(String type, JavaSystemDepartmentWrapper wrapper);

    List<JavaSystemDepartment> getList(String type, JavaSystemDepartmentWrapper wrapper, int page, int size);

    Pagination<JavaSystemDepartment> getPage(String type, JavaSystemDepartmentWrapper wrapper, int page, int size);
}
