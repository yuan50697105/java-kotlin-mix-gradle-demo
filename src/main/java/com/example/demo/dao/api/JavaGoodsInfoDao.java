package com.example.demo.dao.api;

import com.example.demo.entity.JavaGoodsInfo;
import com.example.demo.entity.dto.JavaGoodsInfoWrapper;
import com.example.demo.entity.dto.Pagination;

import java.util.Collection;
import java.util.List;

public interface JavaGoodsInfoDao {
    String getType();

    void saveData(JavaGoodsInfo javaSystemRole);

    void updateData(JavaGoodsInfo javaSystemRole);

    JavaGoodsInfo get(Long id);

    void deleteData(Long[] ids);

    void deleteData(Collection<Long> ids);

    void deleteData(Long id, Long... ids);

    List<JavaGoodsInfo> getList(JavaGoodsInfoWrapper wrapper);

    List<JavaGoodsInfo> getList(JavaGoodsInfoWrapper wrapper, int page, int size);

    Pagination<JavaGoodsInfo> getPage(JavaGoodsInfoWrapper wrapper, int page, int size);
}
