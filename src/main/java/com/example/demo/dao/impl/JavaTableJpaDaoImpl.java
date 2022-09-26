package com.example.demo.dao.impl;

import com.example.demo.constants.JavaDaoType;
import com.example.demo.dao.JavaTableDao;
import com.example.demo.entity.JavaTable;
import com.example.demo.entity.dto.JavaTableWrapper;
import com.example.demo.entity.dto.Pagination;
import com.example.demo.repository.JavaTableRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Service
public class JavaTableJpaDaoImpl implements JavaTableDao {
    private final JavaTableRepository javaTableRepository;

    public JavaTableJpaDaoImpl(JavaTableRepository javaTableRepository) {
        this.javaTableRepository = javaTableRepository;
    }

    @Override
    public String getType() {
        return JavaDaoType.JPA.name();
    }

    @Override
    @Transactional
    public void saveData(JavaTable data) {
        javaTableRepository.save(data);
    }

    @Override
    @Transactional
    public void updateData(JavaTable javaTable) {
        javaTableRepository.save(javaTable);
    }

    @Override
    public JavaTable get(Long id) {
        return javaTableRepository.findById(id).orElse(null);
    }

    @Override
    public List<JavaTable> getList(JavaTableWrapper wrapper) {
        return javaTableRepository.findAll();
    }

    @Override
    public Pagination<JavaTable> getPage(JavaTableWrapper wrapper, int page, int size) {
        return new Pagination<>(javaTableRepository.findAll(PageRequest.of(page <= 1 ? 0 : page - 1, size)));
    }

    @Override
    @Transactional
    public void deleteData(Long[] id) {
        javaTableRepository.deleteAllById(Arrays.asList(id));
    }
}
