package com.example.demo.dao.api.impl;

import com.example.demo.constants.JavaDaoType;
import com.example.demo.dao.api.JavaGoodsStockDao;
import com.example.demo.entity.JavaGoodsStock;
import com.example.demo.entity.dto.JavaGoodsStockWrapper;
import com.example.demo.entity.dto.Pagination;
import com.example.demo.repository.JavaGoodsStockRepository;
import com.google.common.collect.Lists;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class JavaGoodsStockJpaDaoImpl implements JavaGoodsStockDao {
    private final JavaGoodsStockRepository repository;

    public JavaGoodsStockJpaDaoImpl(JavaGoodsStockRepository repository) {
        this.repository = repository;
    }

    @Override
    public String getType() {
        return JavaDaoType.JPA.name();
    }

    @Override
    @Transactional
    public void saveData(JavaGoodsStock javaSystemUser) {
        repository.save(javaSystemUser);
    }

    @Override
    public void updateData(JavaGoodsStock javaSystemUser) {
        repository.save(javaSystemUser);
    }

    @Override
    public JavaGoodsStock get(Long id) {
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
    public List<JavaGoodsStock> getList(JavaGoodsStockWrapper javaSystemUser) {
        return repository.findAll();
    }

    @Override
    public List<JavaGoodsStock> getList(JavaGoodsStockWrapper javaSystemUser, int page, int size) {
        return getPage(javaSystemUser, page, size).getData();
    }

    @Override
    public Pagination<JavaGoodsStock> getPage(JavaGoodsStockWrapper javaSystemUser, int page, int size) {
        return new Pagination<>(repository.findAll(PageRequest.of(page <= 1 ? 0 : page - 1, size)));
    }
}
