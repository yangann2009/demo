package com.mjmh.demo.service;

import com.mjmh.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    /**
     * 根据name查询
     * @param name
     * @return
     */
    public List<Student> findByName(String name);
}