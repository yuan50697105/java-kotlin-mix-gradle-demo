package com.example.demo.dao.factory;

import com.example.demo.entity.JavaCustomerInfo;
import com.example.demo.entity.dto.JavaCustomerInfoWrapper;
import com.example.demo.entity.dto.Pagination;

import java.util.Collection;
import java.util.List;

public interface JavaCustomerInfoDaoFactory {

    void saveData(String type, JavaCustomerInfo data);

    void updateData(String type, JavaCustomerInfo data);

    JavaCustomerInfo get(String type, Long id);

    void deleteData(String type, Long[] ids);

    void deleteData(String type, Collection<Long> ids);

    void deleteData(String type, Long id, Long... ids);

    List<JavaCustomerInfo> getList(String type, JavaCustomerInfoWrapper wrapper);

    List<JavaCustomerInfo> getList(String type, JavaCustomerInfoWrapper wrapper, int page, int size);

    Pagination<JavaCustomerInfo> getPage(String type, JavaCustomerInfoWrapper wrapper, int page, int size);
}
