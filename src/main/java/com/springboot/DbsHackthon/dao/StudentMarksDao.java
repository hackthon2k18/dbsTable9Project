package com.springboot.DbsHackthon.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.DbsHackthon.common.CommonResponse;
import com.springboot.DbsHackthon.model.StudentMarks;
@Service
public interface StudentMarksDao {

	public CommonResponse addMarks(StudentMarks marks);
	
	public List<StudentMarks>  getMarks();
	
	public CommonResponse updateMarks(StudentMarks marks, Long id);
	
	public String deleteMarks(Long id);
	
	public StudentMarks getMarksById(Long id);
	
}
