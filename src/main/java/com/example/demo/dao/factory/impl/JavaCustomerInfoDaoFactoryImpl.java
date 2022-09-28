package com.example.demo.dao.factory.impl;

import cn.hutool.core.util.ObjUtil;
import com.example.demo.constants.JavaDaoType;
import com.example.demo.dao.api.JavaCustomerInfoDao;
import com.example.demo.dao.factory.JavaCustomerInfoDaoFactory;
import com.example.demo.entity.JavaCustomerInfo;
import com.example.demo.entity.dto.JavaCustomerInfoWrapper;
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
public class JavaCustomerInfoDaoFactoryImpl implements JavaCustomerInfoDaoFactory {
    private final Map<String, JavaCustomerInfoDao> daoMap;

    @Autowired
    public JavaCustomerInfoDaoFactoryImpl(List<JavaCustomerInfoDao> systemUserDaoList) {
        this.daoMap = systemUserDaoList.stream().collect(Collectors.toMap(JavaCustomerInfoDao::getType, Function.identity()));
    }

    @Override
    @Transactional
    public void saveData(String type, JavaCustomerInfo javaSystemUser) {
        getJavaCustomerInfoDao(type).saveData(javaSystemUser);

    }

    @Override
    @Transactional
    public void updateData(String type, JavaCustomerInfo javaSystemUser) {
        getJavaCustomerInfoDao(type).updateData(javaSystemUser);
    }

    @Override
    public JavaCustomerInfo get(String type, Long id) {
        return getJavaCustomerInfoDao(type).get(id);
    }

    @Override
    @Transactional
    public void deleteData(String type, Long[] ids) {
        getJavaCustomerInfoDao(type).deleteData(ids);
    }

    @Override
    @Transactional
    public void deleteData(String type, Collection<Long> ids) {
        getJavaCustomerInfoDao(type).deleteData(ids);
    }

    @Override
    @Transactional
    public void deleteData(String type, Long id, Long... ids) {
        getJavaCustomerInfoDao(type).deleteData(ids);
    }

    @Override
    public List<JavaCustomerInfo> getList(String type, JavaCustomerInfoWrapper javaSystemUser) {
        return getJavaCustomerInfoDao(type).getList(javaSystemUser);
    }

    @Override
    public List<JavaCustomerInfo> getList(String type, JavaCustomerInfoWrapper javaSystemUser, int page, int size) {
        return getJavaCustomerInfoDao(type).getList(javaSystemUser, page, size);
    }

    @Override
    public Pagination<JavaCustomerInfo> getPage(String type, JavaCustomerInfoWrapper javaSystemUser, int page, int size) {
        return getJavaCustomerInfoDao(type).getPage(javaSystemUser, page, size);
    }

    private JavaCustomerInfoDao getJavaCustomerInfoDao(String type) {
        JavaCustomerInfoDao javaSystemUserDao = daoMap.get(JavaDaoType.getType(type));
        if (ObjUtil.isNotEmpty(javaSystemUserDao)) {
            return javaSystemUserDao;
        } else {
            throw new IllegalArgumentException(type);
        }
    }
}
