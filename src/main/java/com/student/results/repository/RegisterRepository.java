package com.student.results.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.results.model.Register;

@Repository
public interface RegisterRepository extends JpaRepository<Register, Long> {

	

}
