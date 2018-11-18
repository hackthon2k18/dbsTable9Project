package com.student.results.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.student.results.common.CommonResponse;
import com.student.results.model.StudentMarks;
@Service
public interface StudentMarksDao {

	public CommonResponse addMarks(StudentMarks marks);
	
	public List<StudentMarks>  getMarks();
	
	public CommonResponse updateMarks(StudentMarks marks, Long id);
	
	public String deleteMarks(Long id);
	
	public StudentMarks getMarksById(Long id);
	
}