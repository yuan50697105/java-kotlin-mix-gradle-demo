package com.example.demo.repository;

import com.example.demo.entity.JavaOrderDetail;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface JavaOrderDetailRepository extends JpaRepositoryImplementation<JavaOrderDetail, Long> {
}
