package com.example.demo.repository;

import com.example.demo.entity.JavaOrderInfo;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface JavaOrderInfoRepository extends JpaRepositoryImplementation<JavaOrderInfo, Long> {
}
