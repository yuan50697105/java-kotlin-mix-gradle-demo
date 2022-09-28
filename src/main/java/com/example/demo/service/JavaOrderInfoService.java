package com.example.demo.service;

import com.example.demo.entity.JavaOrderInfo;
import com.example.demo.entity.dto.JavaOrderInfoAddDTO;
import com.example.demo.entity.dto.JavaOrderInfoUpdateDTO;
import com.example.demo.entity.dto.JavaOrderInfoWrapper;
import com.example.demo.entity.dto.Pagination;

import java.util.List;

public interface JavaOrderInfoService {
    void saveData(String type, JavaOrderInfoAddDTO table);

    void updateData(String type, JavaOrderInfoUpdateDTO table);

    void deleteData(String type, Long[] id);

    JavaOrderInfo get(String type, Long id);

    List<JavaOrderInfo> getList(String type, JavaOrderInfoWrapper wrapper);

    Pagination<JavaOrderInfo> getPage(String type, JavaOrderInfoWrapper wrapper, int page, int size);
}
