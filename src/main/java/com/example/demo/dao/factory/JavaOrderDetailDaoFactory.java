package com.example.demo.dao.factory;

import com.example.demo.entity.JavaOrderDetail;
import com.example.demo.entity.dto.JavaOrderDetailWrapper;
import com.example.demo.entity.dto.Pagination;

import java.util.Collection;
import java.util.List;

public interface JavaOrderDetailDaoFactory {

    void saveData(String type, JavaOrderDetail data);

    void updateData(String type, JavaOrderDetail data);

    JavaOrderDetail get(String type, Long id);

    void deleteData(String type, Long[] ids);

    void deleteData(String type, Collection<Long> ids);

    void deleteData(String type, Long id, Long... ids);

    List<JavaOrderDetail> getList(String type, JavaOrderDetailWrapper wrapper);

    List<JavaOrderDetail> getList(String type, JavaOrderDetailWrapper wrapper, int page, int size);

    Pagination<JavaOrderDetail> getPage(String type, JavaOrderDetailWrapper wrapper, int page, int size);
}
