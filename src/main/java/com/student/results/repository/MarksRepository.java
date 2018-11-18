package com.student.results.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.results.model.StudentMarks;

@Repository
public interface MarksRepository extends JpaRepository<StudentMarks, Long> {
}
