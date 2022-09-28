package com.example.demo.service.impl;

import com.example.demo.converter.JavaGoodsStockConverter;
import com.example.demo.dao.factory.JavaGoodsInfoDaoFactory;
import com.example.demo.dao.factory.JavaGoodsStockDaoFactory;
import com.example.demo.entity.JavaGoodsStock;
import com.example.demo.entity.dto.JavaGoodsStockAddDTO;
import com.example.demo.entity.dto.JavaGoodsStockUpdateDTO;
import com.example.demo.entity.dto.JavaGoodsStockWrapper;
import com.example.demo.entity.dto.Pagination;
import com.example.demo.service.JavaGoodsStockService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JavaGoodsStockServiceImpl implements JavaGoodsStockService {
    private final JavaGoodsStockDaoFactory goodsStockDaoFactory;
    private final JavaGoodsInfoDaoFactory goodsInfoDaoFactory;
    private final JavaGoodsStockConverter goodsStockConverter;

    public JavaGoodsStockServiceImpl(JavaGoodsStockDaoFactory goodsStockDaoFactory, JavaGoodsInfoDaoFactory goodsInfoDaoFactory, JavaGoodsStockConverter goodsStockConverter) {
        this.goodsStockDaoFactory = goodsStockDaoFactory;
        this.goodsInfoDaoFactory = goodsInfoDaoFactory;
        this.goodsStockConverter = goodsStockConverter;
    }

    @Override
    public void saveData(String type, JavaGoodsStockAddDTO table) {
        JavaGoodsStock javaSystemUser = goodsStockConverter.convertForAdd(table);
        goodsStockDaoFactory.saveData(type, javaSystemUser);
    }

    @Override
    public void updateData(String type, JavaGoodsStockUpdateDTO table) {
        JavaGoodsStock javaSystemUser = goodsStockConverter.convertForUpdate(table);
        goodsStockDaoFactory.updateData(type, javaSystemUser);
    }

    @Override
    public void deleteData(String type, Long[] id) {
        goodsStockDaoFactory.deleteData(type, id);
    }

    @Override
    public JavaGoodsStock get(String type, Long id) {
        return goodsStockDaoFactory.get(type, id);
    }

    @Override
    public List<JavaGoodsStock> getList(String type, JavaGoodsStockWrapper wrapper) {
        return goodsStockDaoFactory.getList(type, wrapper);
    }

    @Override
    public Pagination<JavaGoodsStock> getPage(String type, JavaGoodsStockWrapper wrapper, int page, int size) {
        return goodsStockDaoFactory.getPage(type, wrapper, page, size);
    }
}
