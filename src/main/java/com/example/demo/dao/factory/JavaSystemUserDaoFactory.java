package com.example.demo.dao.factory;

import com.example.demo.entity.JavaSystemUser;
import com.example.demo.entity.dto.JavaSystemUserWrapper;
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

    List<JavaSystemUser> getList(String type, JavaSystemUserWrapper javaSystemUser);

    List<JavaSystemUser> getList(String type, JavaSystemUserWrapper javaSystemUser, int page, int size);

    Pagination<JavaSystemUser> getPage(String type, JavaSystemUserWrapper javaSystemUser, int page, int size);
}
