package com.example.demo.dao.factory.impl;

import cn.hutool.core.util.ObjUtil;
import com.example.demo.constants.JavaDaoType;
import com.example.demo.dao.api.JavaGoodsInfoDao;
import com.example.demo.dao.factory.JavaGoodsInfoDaoFactory;
import com.example.demo.entity.JavaGoodsInfo;
import com.example.demo.entity.dto.JavaGoodsInfoWrapper;
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
public class JavaGoodsInfoDaoFactoryImpl implements JavaGoodsInfoDaoFactory {
    private final Map<String, JavaGoodsInfoDao> daoMap;

    @Autowired
    public JavaGoodsInfoDaoFactoryImpl(List<JavaGoodsInfoDao> systemUserDaoList) {
        this.daoMap = systemUserDaoList.stream().collect(Collectors.toMap(JavaGoodsInfoDao::getType, Function.identity()));
    }

    @Override
    @Transactional
    public void saveData(String type, JavaGoodsInfo javaSystemUser) {
        getJavaGoodsInfoDao(type).saveData(javaSystemUser);

    }

    @Override
    @Transactional
    public void updateData(String type, JavaGoodsInfo javaSystemUser) {
        getJavaGoodsInfoDao(type).updateData(javaSystemUser);
    }

    @Override
    public JavaGoodsInfo get(String type, Long id) {
        return getJavaGoodsInfoDao(type).get(id);
    }

    @Override
    @Transactional
    public void deleteData(String type, Long[] ids) {
        getJavaGoodsInfoDao(type).deleteData(ids);
    }

    @Override
    @Transactional
    public void deleteData(String type, Collection<Long> ids) {
        getJavaGoodsInfoDao(type).deleteData(ids);
    }

    @Override
    @Transactional
    public void deleteData(String type, Long id, Long... ids) {
        getJavaGoodsInfoDao(type).deleteData(ids);
    }

    @Override
    public List<JavaGoodsInfo> getList(String type, JavaGoodsInfoWrapper javaSystemUser) {
        return getJavaGoodsInfoDao(type).getList(javaSystemUser);
    }

    @Override
    public List<JavaGoodsInfo> getList(String type, JavaGoodsInfoWrapper javaSystemUser, int page, int size) {
        return getJavaGoodsInfoDao(type).getList(javaSystemUser, page, size);
    }

    @Override
    public Pagination<JavaGoodsInfo> getPage(String type, JavaGoodsInfoWrapper javaSystemUser, int page, int size) {
        return getJavaGoodsInfoDao(type).getPage(javaSystemUser, page, size);
    }

    private JavaGoodsInfoDao getJavaGoodsInfoDao(String type) {
        JavaGoodsInfoDao javaSystemUserDao = daoMap.get(JavaDaoType.getType(type));
        if (ObjUtil.isNotEmpty(javaSystemUserDao)) {
            return javaSystemUserDao;
        } else {
            throw new IllegalArgumentException(type);
        }
    }
}
