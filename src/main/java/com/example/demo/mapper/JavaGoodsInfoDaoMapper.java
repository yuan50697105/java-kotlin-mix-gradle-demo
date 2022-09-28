package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.JavaGoodsInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.ExampleMapper;

@Mapper
@Component
public interface JavaGoodsInfoDaoMapper extends BaseMapper<JavaGoodsInfo>, ExampleMapper<JavaGoodsInfo> {
}
