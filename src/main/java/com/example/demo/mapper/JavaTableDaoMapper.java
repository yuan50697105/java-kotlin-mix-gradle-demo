package com.example.demo.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.JavaTable;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.ExampleMapper;

@Mapper
@Component
public interface JavaTableDaoMapper extends BaseMapper<JavaTable>, ExampleMapper<JavaTable> {
}
