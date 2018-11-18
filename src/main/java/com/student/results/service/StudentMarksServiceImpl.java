package com.student.results.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.results.common.CommonResponse;
import com.student.results.dao.StudentMarksDao;
import com.student.results.model.StudentMarks;

@Service
public class StudentMarksServiceImpl implements StudentMarksService {

	@Autowired
	private StudentMarksDao marksdao;

	@Override
	public CommonResponse addMarks(StudentMarks marks) {
		CommonResponse response = null;
		if (marks.getId() == null) {
			return null;
		}
		response = marksdao.addMarks(marks);
		if (response == null) {
			return null;
		}
		return response;
	}

	@Override
	public List<StudentMarks> getMarks() {

		return marksdao.getMarks();
	}

	@Override
	public CommonResponse updateMarks(StudentMarks marks, Long id) {
		CommonResponse response = null;
		if (id == null) {
			return null;
		}
		response = marksdao.updateMarks(marks, id);
		if (response == null) {
			return null;
		}
		return response;
	}

	@Override
	public String deleteMarks(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentMarks getMarksById(Long id) {
		StudentMarks response = null;
		if(id == null){
			return null;
		}
		response = marksdao.getMarksById(id);
		return response;
	}

}
