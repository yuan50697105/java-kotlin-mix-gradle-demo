package com.example.demo.entity.dto;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
public class Pagination<T> {
    private List<T> data;
    private long page;
    private long size;
    private long total;
    private long totalPage;

    public Pagination(Page<T> page) {
        this(page.getContent(), page.getPageable().getPageNumber() + 1, page.getPageable().getPageSize(), page.getTotalElements(), page.getTotalPages());
    }

    public <E extends IPage<T>> Pagination(E iPage) {
        this(iPage.getRecords(), iPage.getCurrent(), iPage.getSize(), iPage.getTotal(), iPage.getPages());
    }

    public Pagination(PageInfo<T> pageInfo) {
        this(pageInfo.getList(), pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getTotal(), pageInfo.getPages());
    }

    public Pagination(List<T> data, long page, long size, long total, long totalPage) {
        this.data = data;
        this.page = page;
        this.size = size;
        this.total = total;
        this.totalPage = totalPage;
    }


}
