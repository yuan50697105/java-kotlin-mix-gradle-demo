package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.JavaOrderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.ExampleMapper;

@Mapper
@Component
public interface JavaOrderDetailDaoMapper extends BaseMapper<JavaOrderDetail>, ExampleMapper<JavaOrderDetail> {
}
