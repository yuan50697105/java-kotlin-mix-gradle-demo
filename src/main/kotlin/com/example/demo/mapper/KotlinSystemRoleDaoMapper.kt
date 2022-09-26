package com.example.demo.mapper

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.example.demo.entity.KotlinSystemRole
import org.apache.ibatis.annotations.Mapper
import org.springframework.stereotype.Component
import tk.mybatis.mapper.common.ExampleMapper

@Mapper
@Component
interface KotlinSystemRoleDaoMapper : BaseMapper<KotlinSystemRole>, ExampleMapper<KotlinSystemRole> {}