package com.example.demo.repository;

import com.example.demo.entity.JavaCustomerInfo;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface JavaCustomerInfoRepository extends JpaRepositoryImplementation<JavaCustomerInfo, Long> {
}
