package com.example.demo.repository;

import com.example.demo.entity.JavaTable;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface JavaTableRepository extends JpaRepositoryImplementation<JavaTable,Long> {
}
