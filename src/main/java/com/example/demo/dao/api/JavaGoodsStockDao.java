package com.example.demo.dao.api;

import com.example.demo.entity.JavaGoodsStock;
import com.example.demo.entity.dto.JavaGoodsStockWrapper;
import com.example.demo.entity.dto.Pagination;

import java.util.Collection;
import java.util.List;

public interface JavaGoodsStockDao {
    String getType();

    void saveData(JavaGoodsStock javaSystemRole);

    void updateData(JavaGoodsStock javaSystemRole);

    JavaGoodsStock get(Long id);

    void deleteData(Long[] ids);

    void deleteData(Collection<Long> ids);

    void deleteData(Long id, Long... ids);

    List<JavaGoodsStock> getList(JavaGoodsStockWrapper wrapper);

    List<JavaGoodsStock> getList(JavaGoodsStockWrapper wrapper, int page, int size);

    Pagination<JavaGoodsStock> getPage(JavaGoodsStockWrapper wrapper, int page, int size);
}
