package com.example.demo.dao.impl

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.example.demo.dao.KotlinTableDao
import com.example.demo.entity.KotlinTable
import com.example.demo.mapper.KotlinTableDaoMapper
import com.example.demo.service.JavaTableDaoFactory
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class KotlinTablePlusDaoImpl : ServiceImpl<KotlinTableDaoMapper, KotlinTable>(), KotlinTableDao {
    override fun getType(): String {
        return JavaTableDaoFactory.DaoType.PLUS.type
    }

    @Transactional
    override fun saveData(kotlinTable: KotlinTable) {
        this.save(kotlinTable)
    }
}