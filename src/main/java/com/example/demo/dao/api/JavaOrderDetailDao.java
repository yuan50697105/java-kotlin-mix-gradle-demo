package com.example.demo.dao.api;

import com.example.demo.entity.JavaOrderDetail;
import com.example.demo.entity.dto.JavaOrderDetailWrapper;
import com.example.demo.entity.dto.Pagination;

import java.util.Collection;
import java.util.List;

public interface JavaOrderDetailDao {
    String getType();

    void saveData(JavaOrderDetail javaSystemRole);

    void updateData(JavaOrderDetail javaSystemRole);

    JavaOrderDetail get(Long id);

    void deleteData(Long[] ids);

    void deleteData(Collection<Long> ids);

    void deleteData(Long id, Long... ids);

    List<JavaOrderDetail> getList(JavaOrderDetailWrapper wrapper);

    List<JavaOrderDetail> getList(JavaOrderDetailWrapper wrapper, int page, int size);

    Pagination<JavaOrderDetail> getPage(JavaOrderDetailWrapper wrapper, int page, int size);
}
