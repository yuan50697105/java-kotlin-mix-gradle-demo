package com.example.demo.dao.impl;

import cn.org.atool.fluent.mybatis.base.IBaseDao;
import com.example.demo.constants.JavaDaoType;
import com.example.demo.dao.JavaTableDao;
import com.example.demo.dao.base.JavaTableBaseDao;
import com.example.demo.entity.JavaTable;
import com.example.demo.entity.dto.JavaTableWrapper;
import com.example.demo.entity.dto.Pagination;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Service
public class JavaTableFluentDaoImpl extends JavaTableBaseDao implements IBaseDao<JavaTable>, JavaTableDao {
    @Override
    public String getType() {
        return JavaDaoType.FLUENT.name();
    }

    @Override
    @Transactional
    public void saveData(JavaTable data) {
        this.save(data);
    }

    @Override
    @Transactional
    public void updateData(JavaTable javaTable) {
        this.updateById(javaTable);
    }

    @Override
    public JavaTable get(Long id) {
        return selectById(id);
    }

    @Override
    public List<JavaTable> getList(JavaTableWrapper wrapper) {
        return listEntity(query());
    }

    @Override
    public Pagination<JavaTable> getPage(JavaTableWrapper wrapper, int page, int size) {
        PageHelper.startPage(page, size);
        return new Pagination<JavaTable>(PageInfo.of(listEntity(query())));
    }

    @Override
    @Transactional
    public void deleteData(Long[] id) {
        this.deleteByIds(Arrays.asList(id));
    }
}
