package com.example.demo.service;

import com.example.demo.entity.JavaSystemUser;
import com.example.demo.entity.dto.Pagination;

import java.util.Collection;
import java.util.List;

public interface JavaSystemUserDaoFactory {

    void saveData(String type, JavaSystemUser javaSystemUser);

    void updateData(String type, JavaSystemUser javaSystemUser);

    JavaSystemUser get(String type, Long id);

    void deleteData(String type, Long[] ids);

    void deleteData(String type, Collection<Long> ids);

    void deleteData(String type, Long id, Long... ids);

    List<JavaSystemUser> getList(String type, JavaSystemUser javaSystemUser);

    List<JavaSystemUser> getList(String type, JavaSystemUser javaSystemUser, int page, int size);

    Pagination<JavaSystemUser> getPage(String type, JavaSystemUser javaSystemUser, int page, int size);
}
