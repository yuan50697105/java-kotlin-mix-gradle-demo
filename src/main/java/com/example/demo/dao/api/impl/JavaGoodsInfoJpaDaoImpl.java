package com.example.demo.dao.api.impl;

import com.example.demo.constants.JavaDaoType;
import com.example.demo.dao.api.JavaGoodsInfoDao;
import com.example.demo.entity.JavaGoodsInfo;
import com.example.demo.entity.dto.JavaGoodsInfoWrapper;
import com.example.demo.entity.dto.Pagination;
import com.example.demo.repository.JavaGoodsInfoRepository;
import com.google.common.collect.Lists;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class JavaGoodsInfoJpaDaoImpl implements JavaGoodsInfoDao {
    private final JavaGoodsInfoRepository repository;

    public JavaGoodsInfoJpaDaoImpl(JavaGoodsInfoRepository repository) {
        this.repository = repository;
    }

    @Override
    public String getType() {
        return JavaDaoType.JPA.name();
    }

    @Override
    @Transactional
    public void saveData(JavaGoodsInfo javaSystemUser) {
        repository.save(javaSystemUser);
    }

    @Override
    public void updateData(JavaGoodsInfo javaSystemUser) {
        repository.save(javaSystemUser);
    }

    @Override
    public JavaGoodsInfo get(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void deleteData(Long[] ids) {
        this.deleteData(Arrays.asList(ids));
    }

    @Override
    @Transactional
    public void deleteData(Collection<Long> ids) {
        repository.deleteAllById(ids);
    }

    @Override
    public void deleteData(Long id, Long... ids) {
        this.deleteData(Lists.asList(id, ids));
    }

    @Override
    public List<JavaGoodsInfo> getList(JavaGoodsInfoWrapper javaSystemUser) {
        return repository.findAll();
    }

    @Override
    public List<JavaGoodsInfo> getList(JavaGoodsInfoWrapper javaSystemUser, int page, int size) {
        return getPage(javaSystemUser, page, size).getData();
    }

    @Override
    public Pagination<JavaGoodsInfo> getPage(JavaGoodsInfoWrapper javaSystemUser, int page, int size) {
        return new Pagination<>(repository.findAll(PageRequest.of(page <= 1 ? 0 : page - 1, size)));
    }
}
