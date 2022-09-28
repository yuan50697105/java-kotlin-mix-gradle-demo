package com.example.demo.repository;

import com.example.demo.entity.JavaGoodsStock;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface JavaGoodsStockRepository extends JpaRepositoryImplementation<JavaGoodsStock, Long> {
}
