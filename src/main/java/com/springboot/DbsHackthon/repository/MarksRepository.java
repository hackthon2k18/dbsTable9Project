package com.springboot.DbsHackthon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.DbsHackthon.model.StudentMarks;

@Repository
public interface MarksRepository extends JpaRepository<StudentMarks, Long> {
}
