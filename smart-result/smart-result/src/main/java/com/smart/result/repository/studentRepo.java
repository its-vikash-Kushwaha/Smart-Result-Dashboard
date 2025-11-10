package com.smart.result.repository;

import com.smart.result.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface studentRepo extends JpaRepository<Student,String> {

    Student findByRollNumber(String rollNumber);
}
