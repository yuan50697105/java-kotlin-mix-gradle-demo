package com.example.demo.dao.factory.impl;

import cn.hutool.core.util.ObjUtil;
import com.example.demo.constants.JavaDaoType;
import com.example.demo.dao.api.JavaGoodsStockDao;
import com.example.demo.dao.factory.JavaGoodsStockDaoFactory;
import com.example.demo.entity.JavaGoodsStock;
import com.example.demo.entity.dto.JavaGoodsStockWrapper;
import com.example.demo.entity.dto.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class JavaGoodsStockDaoFactoryImpl implements JavaGoodsStockDaoFactory {
    private final Map<String, JavaGoodsStockDao> daoMap;

    @Autowired
    public JavaGoodsStockDaoFactoryImpl(List<JavaGoodsStockDao> systemUserDaoList) {
        this.daoMap = systemUserDaoList.stream().collect(Collectors.toMap(JavaGoodsStockDao::getType, Function.identity()));
    }

    @Override
    @Transactional
    public void saveData(String type, JavaGoodsStock javaSystemUser) {
        getJavaGoodsStockDao(type).saveData(javaSystemUser);

    }

    @Override
    @Transactional
    public void updateData(String type, JavaGoodsStock javaSystemUser) {
        getJavaGoodsStockDao(type).updateData(javaSystemUser);
    }

    @Override
    public JavaGoodsStock get(String type, Long id) {
        return getJavaGoodsStockDao(type).get(id);
    }

    @Override
    @Transactional
    public void deleteData(String type, Long[] ids) {
        getJavaGoodsStockDao(type).deleteData(ids);
    }

    @Override
    @Transactional
    public void deleteData(String type, Collection<Long> ids) {
        getJavaGoodsStockDao(type).deleteData(ids);
    }

    @Override
    @Transactional
    public void deleteData(String type, Long id, Long... ids) {
        getJavaGoodsStockDao(type).deleteData(ids);
    }

    @Override
    public List<JavaGoodsStock> getList(String type, JavaGoodsStockWrapper javaSystemUser) {
        return getJavaGoodsStockDao(type).getList(javaSystemUser);
    }

    @Override
    public List<JavaGoodsStock> getList(String type, JavaGoodsStockWrapper javaSystemUser, int page, int size) {
        return getJavaGoodsStockDao(type).getList(javaSystemUser, page, size);
    }

    @Override
    public Pagination<JavaGoodsStock> getPage(String type, JavaGoodsStockWrapper javaSystemUser, int page, int size) {
        return getJavaGoodsStockDao(type).getPage(javaSystemUser, page, size);
    }

    private JavaGoodsStockDao getJavaGoodsStockDao(String type) {
        JavaGoodsStockDao javaSystemUserDao = daoMap.get(JavaDaoType.getType(type));
        if (ObjUtil.isNotEmpty(javaSystemUserDao)) {
            return javaSystemUserDao;
        } else {
            throw new IllegalArgumentException(type);
        }
    }
}
