package com.example.demo.service.impl;

import com.example.demo.converter.JavaCustomerInfoConverter;
import com.example.demo.dao.factory.JavaCustomerInfoDaoFactory;
import com.example.demo.entity.JavaCustomerInfo;
import com.example.demo.entity.dto.JavaCustomerInfoAddDTO;
import com.example.demo.entity.dto.JavaCustomerInfoUpdateDTO;
import com.example.demo.entity.dto.JavaCustomerInfoWrapper;
import com.example.demo.entity.dto.Pagination;
import com.example.demo.service.JavaCustomerInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JavaCustomerInfoServiceImpl implements JavaCustomerInfoService {
    private final JavaCustomerInfoDaoFactory daoFactory;
    private final JavaCustomerInfoConverter converter;

    public JavaCustomerInfoServiceImpl(JavaCustomerInfoDaoFactory daoFactory, JavaCustomerInfoConverter converter) {
        this.daoFactory = daoFactory;
        this.converter = converter;
    }

    @Override
    public void saveData(String type, JavaCustomerInfoAddDTO table) {
        JavaCustomerInfo javaSystemUser = converter.convertForAdd(table);
        daoFactory.saveData(type, javaSystemUser);
    }

    @Override
    public void updateData(String type, JavaCustomerInfoUpdateDTO table) {
        JavaCustomerInfo javaSystemUser = converter.convertForUpdate(table);
        daoFactory.updateData(type, javaSystemUser);
    }

    @Override
    public void deleteData(String type, Long[] id) {
        daoFactory.deleteData(type, id);
    }

    @Override
    public JavaCustomerInfo get(String type, Long id) {
        return daoFactory.get(type, id);
    }

    @Override
    public List<JavaCustomerInfo> getList(String type, JavaCustomerInfoWrapper wrapper) {
        return daoFactory.getList(type, wrapper);
    }

    @Override
    public Pagination<JavaCustomerInfo> getPage(String type, JavaCustomerInfoWrapper wrapper, int page, int size) {
        return daoFactory.getPage(type, wrapper, page, size);
    }
}
