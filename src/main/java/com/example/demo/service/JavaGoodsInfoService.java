package com.example.demo.service;

import com.example.demo.entity.JavaGoodsInfo;
import com.example.demo.entity.dto.JavaGoodsInfoAddDTO;
import com.example.demo.entity.dto.JavaGoodsInfoUpdateDTO;
import com.example.demo.entity.dto.JavaGoodsInfoWrapper;
import com.example.demo.entity.dto.Pagination;

import java.util.List;

public interface JavaGoodsInfoService {
    void saveData(String type, JavaGoodsInfoAddDTO table);

    void updateData(String type, JavaGoodsInfoUpdateDTO table);

    void deleteData(String type, Long[] id);

    JavaGoodsInfo get(String type, Long id);

    List<JavaGoodsInfo> getList(String type, JavaGoodsInfoWrapper wrapper);

    Pagination<JavaGoodsInfo> getPage(String type, JavaGoodsInfoWrapper wrapper, int page, int size);
}
