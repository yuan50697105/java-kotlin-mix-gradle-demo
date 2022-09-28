package com.example.demo.dao.factory.impl;

import cn.hutool.core.util.ObjUtil;
import com.example.demo.constants.JavaDaoType;
import com.example.demo.dao.api.JavaOrderInfoDao;
import com.example.demo.dao.factory.JavaOrderInfoDaoFactory;
import com.example.demo.entity.JavaOrderInfo;
import com.example.demo.entity.dto.JavaOrderInfoWrapper;
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
public class JavaOrderInfoDaoFactoryImpl implements JavaOrderInfoDaoFactory {
    private final Map<String, JavaOrderInfoDao> daoMap;

    @Autowired
    public JavaOrderInfoDaoFactoryImpl(List<JavaOrderInfoDao> systemUserDaoList) {
        this.daoMap = systemUserDaoList.stream().collect(Collectors.toMap(JavaOrderInfoDao::getType, Function.identity()));
    }

    @Override
    @Transactional
    public void saveData(String type, JavaOrderInfo javaSystemUser) {
        getJavaOrderInfoDao(type).saveData(javaSystemUser);

    }

    @Override
    @Transactional
    public void updateData(String type, JavaOrderInfo javaSystemUser) {
        getJavaOrderInfoDao(type).updateData(javaSystemUser);
    }

    @Override
    public JavaOrderInfo get(String type, Long id) {
        return getJavaOrderInfoDao(type).get(id);
    }

    @Override
    @Transactional
    public void deleteData(String type, Long[] ids) {
        getJavaOrderInfoDao(type).deleteData(ids);
    }

    @Override
    @Transactional
    public void deleteData(String type, Collection<Long> ids) {
        getJavaOrderInfoDao(type).deleteData(ids);
    }

    @Override
    @Transactional
    public void deleteData(String type, Long id, Long... ids) {
        getJavaOrderInfoDao(type).deleteData(ids);
    }

    @Override
    public List<JavaOrderInfo> getList(String type, JavaOrderInfoWrapper javaSystemUser) {
        return getJavaOrderInfoDao(type).getList(javaSystemUser);
    }

    @Override
    public List<JavaOrderInfo> getList(String type, JavaOrderInfoWrapper javaSystemUser, int page, int size) {
        return getJavaOrderInfoDao(type).getList(javaSystemUser, page, size);
    }

    @Override
    public Pagination<JavaOrderInfo> getPage(String type, JavaOrderInfoWrapper javaSystemUser, int page, int size) {
        return getJavaOrderInfoDao(type).getPage(javaSystemUser, page, size);
    }

    private JavaOrderInfoDao getJavaOrderInfoDao(String type) {
        JavaOrderInfoDao javaSystemUserDao = daoMap.get(JavaDaoType.getType(type));
        if (ObjUtil.isNotEmpty(javaSystemUserDao)) {
            return javaSystemUserDao;
        } else {
            throw new IllegalArgumentException(type);
        }
    }
}
