package com.example.demo.dao.factory;

import com.example.demo.entity.JavaOrderInfo;
import com.example.demo.entity.dto.JavaOrderInfoWrapper;
import com.example.demo.entity.dto.Pagination;

import java.util.Collection;
import java.util.List;

public interface JavaOrderInfoDaoFactory {

    void saveData(String type, JavaOrderInfo data);

    void updateData(String type, JavaOrderInfo data);

    JavaOrderInfo get(String type, Long id);

    void deleteData(String type, Long[] ids);

    void deleteData(String type, Collection<Long> ids);

    void deleteData(String type, Long id, Long... ids);

    List<JavaOrderInfo> getList(String type, JavaOrderInfoWrapper wrapper);

    List<JavaOrderInfo> getList(String type, JavaOrderInfoWrapper wrapper, int page, int size);

    Pagination<JavaOrderInfo> getPage(String type, JavaOrderInfoWrapper wrapper, int page, int size);
}
