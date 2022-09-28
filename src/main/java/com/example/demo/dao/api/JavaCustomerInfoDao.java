package com.example.demo.dao.api;

import com.example.demo.entity.JavaCustomerInfo;
import com.example.demo.entity.dto.JavaCustomerInfoWrapper;
import com.example.demo.entity.dto.Pagination;

import java.util.Collection;
import java.util.List;

public interface JavaCustomerInfoDao {
    String getType();

    void saveData(JavaCustomerInfo javaSystemRole);

    void updateData(JavaCustomerInfo javaSystemRole);

    JavaCustomerInfo get(Long id);

    void deleteData(Long[] ids);

    void deleteData(Collection<Long> ids);

    void deleteData(Long id, Long... ids);

    List<JavaCustomerInfo> getList(JavaCustomerInfoWrapper wrapper);

    List<JavaCustomerInfo> getList(JavaCustomerInfoWrapper wrapper, int page, int size);

    Pagination<JavaCustomerInfo> getPage(JavaCustomerInfoWrapper wrapper, int page, int size);
}
