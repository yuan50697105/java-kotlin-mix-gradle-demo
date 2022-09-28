package com.example.demo.dao.factory;

import com.example.demo.entity.JavaGoodsStock;
import com.example.demo.entity.dto.JavaGoodsStockWrapper;
import com.example.demo.entity.dto.Pagination;

import java.util.Collection;
import java.util.List;

public interface JavaGoodsStockDaoFactory {

    void saveData(String type, JavaGoodsStock data);

    void updateData(String type, JavaGoodsStock data);

    JavaGoodsStock get(String type, Long id);

    void deleteData(String type, Long[] ids);

    void deleteData(String type, Collection<Long> ids);

    void deleteData(String type, Long id, Long... ids);

    List<JavaGoodsStock> getList(String type, JavaGoodsStockWrapper wrapper);

    List<JavaGoodsStock> getList(String type, JavaGoodsStockWrapper wrapper, int page, int size);

    Pagination<JavaGoodsStock> getPage(String type, JavaGoodsStockWrapper wrapper, int page, int size);
}
