package com.example.demo.dao;

import com.example.demo.entity.JavaSystemUser;
import com.example.demo.entity.dto.Pagination;

import java.util.Collection;
import java.util.List;

public interface JavaSystemUserDao {
    String getType();

    void saveData(JavaSystemUser javaSystemUser);

    void updateData(JavaSystemUser javaSystemUser);

    JavaSystemUser get(Long id);

    void deleteData(Long[] ids);

    void deleteData(Collection<Long> ids);

    void deleteData(Long id, Long... ids);

    List<JavaSystemUser> getList(JavaSystemUser javaSystemUser);

    List<JavaSystemUser> getList(JavaSystemUser javaSystemUser, int page, int size);

    Pagination<JavaSystemUser> getPage(JavaSystemUser javaSystemUser, int page, int size);
}
