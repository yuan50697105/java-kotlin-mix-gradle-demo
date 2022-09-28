package com.example.demo.repository;

import com.example.demo.entity.JavaGoodsInfo;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface JavaGoodsInfoRepository extends JpaRepositoryImplementation<JavaGoodsInfo, Long> {
}
