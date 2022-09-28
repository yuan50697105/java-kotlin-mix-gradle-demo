package com.example.demo.service;

import com.example.demo.entity.JavaGoodsStock;
import com.example.demo.entity.dto.JavaGoodsStockAddDTO;
import com.example.demo.entity.dto.JavaGoodsStockUpdateDTO;
import com.example.demo.entity.dto.JavaGoodsStockWrapper;
import com.example.demo.entity.dto.Pagination;

import java.util.List;

public interface JavaGoodsStockService {
    void saveData(String type, JavaGoodsStockAddDTO table);

    void updateData(String type, JavaGoodsStockUpdateDTO table);

    void deleteData(String type, Long[] id);

    JavaGoodsStock get(String type, Long id);

    List<JavaGoodsStock> getList(String type, JavaGoodsStockWrapper wrapper);

    Pagination<JavaGoodsStock> getPage(String type, JavaGoodsStockWrapper wrapper, int page, int size);
}
