package com.example.demo.service;

import com.example.demo.entity.JavaCustomerInfo;
import com.example.demo.entity.dto.JavaCustomerInfoAddDTO;
import com.example.demo.entity.dto.JavaCustomerInfoUpdateDTO;
import com.example.demo.entity.dto.JavaCustomerInfoWrapper;
import com.example.demo.entity.dto.Pagination;

import java.util.List;

public interface JavaCustomerInfoService {
    void saveData(String type, JavaCustomerInfoAddDTO table);

    void updateData(String type, JavaCustomerInfoUpdateDTO table);

    void deleteData(String type, Long[] id);

    JavaCustomerInfo get(String type, Long id);

    List<JavaCustomerInfo> getList(String type, JavaCustomerInfoWrapper wrapper);

    Pagination<JavaCustomerInfo> getPage(String type, JavaCustomerInfoWrapper wrapper, int page, int size);
}
