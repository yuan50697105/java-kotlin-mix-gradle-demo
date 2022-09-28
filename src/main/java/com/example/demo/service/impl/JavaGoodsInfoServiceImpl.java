package com.example.demo.service.impl;

import com.example.demo.converter.JavaGoodsInfoConverter;
import com.example.demo.dao.factory.JavaGoodsInfoDaoFactory;
import com.example.demo.entity.JavaGoodsInfo;
import com.example.demo.entity.dto.JavaGoodsInfoAddDTO;
import com.example.demo.entity.dto.JavaGoodsInfoUpdateDTO;
import com.example.demo.entity.dto.JavaGoodsInfoWrapper;
import com.example.demo.entity.dto.Pagination;
import com.example.demo.service.JavaGoodsInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JavaGoodsInfoServiceImpl implements JavaGoodsInfoService {
    private final JavaGoodsInfoDaoFactory daoFactory;
    private final JavaGoodsInfoConverter converter;

    public JavaGoodsInfoServiceImpl(JavaGoodsInfoDaoFactory daoFactory, JavaGoodsInfoConverter converter) {
        this.daoFactory = daoFactory;
        this.converter = converter;
    }

    @Override
    public void saveData(String type, JavaGoodsInfoAddDTO table) {
        JavaGoodsInfo javaSystemUser = converter.convertForAdd(table);
        daoFactory.saveData(type, javaSystemUser);
    }

    @Override
    public void updateData(String type, JavaGoodsInfoUpdateDTO table) {
        JavaGoodsInfo javaSystemUser = converter.convertForUpdate(table);
        daoFactory.updateData(type, javaSystemUser);
    }

    @Override
    public void deleteData(String type, Long[] id) {
        daoFactory.deleteData(type, id);
    }

    @Override
    public JavaGoodsInfo get(String type, Long id) {
        return daoFactory.get(type, id);
    }

    @Override
    public List<JavaGoodsInfo> getList(String type, JavaGoodsInfoWrapper wrapper) {
        return daoFactory.getList(type, wrapper);
    }

    @Override
    public Pagination<JavaGoodsInfo> getPage(String type, JavaGoodsInfoWrapper wrapper, int page, int size) {
        return daoFactory.getPage(type, wrapper, page, size);
    }
}
