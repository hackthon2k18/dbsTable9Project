package com.springboot.DbsHackthon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.DbsHackthon.common.CommonResponse;
import com.springboot.DbsHackthon.dao.StudentMarksDao;
import com.springboot.DbsHackthon.model.StudentMarks;

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
