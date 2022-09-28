package com.example.demo.dao.api;

import com.example.demo.entity.JavaOrderInfo;
import com.example.demo.entity.dto.JavaOrderInfoWrapper;
import com.example.demo.entity.dto.Pagination;

import java.util.Collection;
import java.util.List;

public interface JavaOrderInfoDao {
    String getType();

    void saveData(JavaOrderInfo javaSystemRole);

    void updateData(JavaOrderInfo javaSystemRole);

    JavaOrderInfo get(Long id);

    void deleteData(Long[] ids);

    void deleteData(Collection<Long> ids);

    void deleteData(Long id, Long... ids);

    List<JavaOrderInfo> getList(JavaOrderInfoWrapper wrapper);

    List<JavaOrderInfo> getList(JavaOrderInfoWrapper wrapper, int page, int size);

    Pagination<JavaOrderInfo> getPage(JavaOrderInfoWrapper wrapper, int page, int size);
}
