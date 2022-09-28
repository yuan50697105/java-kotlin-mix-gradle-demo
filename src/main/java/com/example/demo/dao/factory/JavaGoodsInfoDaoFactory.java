package com.example.demo.dao.factory;

import com.example.demo.entity.JavaGoodsInfo;
import com.example.demo.entity.dto.JavaGoodsInfoWrapper;
import com.example.demo.entity.dto.Pagination;

import java.util.Collection;
import java.util.List;

public interface JavaGoodsInfoDaoFactory {

    void saveData(String type, JavaGoodsInfo data);

    void updateData(String type, JavaGoodsInfo data);

    JavaGoodsInfo get(String type, Long id);

    void deleteData(String type, Long[] ids);

    void deleteData(String type, Collection<Long> ids);

    void deleteData(String type, Long id, Long... ids);

    List<JavaGoodsInfo> getList(String type, JavaGoodsInfoWrapper wrapper);

    List<JavaGoodsInfo> getList(String type, JavaGoodsInfoWrapper wrapper, int page, int size);

    Pagination<JavaGoodsInfo> getPage(String type, JavaGoodsInfoWrapper wrapper, int page, int size);
}
