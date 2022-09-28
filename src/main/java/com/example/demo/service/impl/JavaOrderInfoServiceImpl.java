package com.example.demo.service.impl;

import com.example.demo.converter.JavaOrderDetailConverter;
import com.example.demo.converter.JavaOrderInfoConverter;
import com.example.demo.dao.factory.JavaOrderDetailDaoFactory;
import com.example.demo.dao.factory.JavaOrderInfoDaoFactory;
import com.example.demo.entity.JavaOrderInfo;
import com.example.demo.entity.dto.JavaOrderInfoAddDTO;
import com.example.demo.entity.dto.JavaOrderInfoUpdateDTO;
import com.example.demo.entity.dto.JavaOrderInfoWrapper;
import com.example.demo.entity.dto.Pagination;
import com.example.demo.service.JavaOrderInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JavaOrderInfoServiceImpl implements JavaOrderInfoService {
    private final JavaOrderInfoDaoFactory orderInfoDaoFactory;
    private final JavaOrderDetailDaoFactory orderDetailDaoFactory;
    private final JavaOrderInfoConverter orderInfoConverter;
    private final JavaOrderDetailConverter orderDetailConverter;

    public JavaOrderInfoServiceImpl(JavaOrderInfoDaoFactory orderInfoDaoFactory, JavaOrderDetailDaoFactory orderDetailDaoFactory, JavaOrderInfoConverter orderInfoConverter, JavaOrderDetailConverter orderDetailConverter) {
        this.orderInfoDaoFactory = orderInfoDaoFactory;
        this.orderDetailDaoFactory = orderDetailDaoFactory;
        this.orderInfoConverter = orderInfoConverter;
        this.orderDetailConverter = orderDetailConverter;
    }

    @Override
    public void saveData(String type, JavaOrderInfoAddDTO table) {
        JavaOrderInfo javaSystemUser = orderInfoConverter.convertForAdd(table);
        orderInfoDaoFactory.saveData(type, javaSystemUser);
    }

    @Override
    public void updateData(String type, JavaOrderInfoUpdateDTO table) {
        JavaOrderInfo javaSystemUser = orderInfoConverter.convertForUpdate(table);
        orderInfoDaoFactory.updateData(type, javaSystemUser);
    }

    @Override
    public void deleteData(String type, Long[] id) {
        orderInfoDaoFactory.deleteData(type, id);
    }

    @Override
    public JavaOrderInfo get(String type, Long id) {
        return orderInfoDaoFactory.get(type, id);
    }

    @Override
    public List<JavaOrderInfo> getList(String type, JavaOrderInfoWrapper wrapper) {
        return orderInfoDaoFactory.getList(type, wrapper);
    }

    @Override
    public Pagination<JavaOrderInfo> getPage(String type, JavaOrderInfoWrapper wrapper, int page, int size) {
        return orderInfoDaoFactory.getPage(type, wrapper, page, size);
    }
}
