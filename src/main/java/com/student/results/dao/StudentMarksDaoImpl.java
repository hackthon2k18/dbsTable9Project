package com.student.results.dao;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.student.results.common.CommonResponse;
import com.student.results.model.StudentMarks;
import com.student.results.repository.MarksRepository;

@Service
public class StudentMarksDaoImpl implements StudentMarksDao {

	@Autowired
	private MarksRepository marksrepo;

	@Autowired
	private JdbcTemplate jdbc;

	@SuppressWarnings("null")
	@Override
	public CommonResponse addMarks(StudentMarks marks) {
		CommonResponse response = null;
		try {
			int rs = jdbc.update(" update student_marks set c = " + marks.getC() + ", java= " + marks.getJava()
					+ ", linux=" + marks.getLinux() + ", python=" + marks.getPython() + " where id =" + marks.getId());
			if (rs > 0) {
				response = new CommonResponse();
				response.setResponse("Successfully added marks");
				response.setId(marks.getId());
			}
		} catch (Exception e) {
			System.out.println(e + " while adding error");
		}
		return response;
	}

	@Override
	public List<StudentMarks> getMarks() {
		List<StudentMarks> list = marksrepo.findAll(new Sort(Sort.Direction.ASC, "id"));
		return list;
	}

	@Override
	public CommonResponse updateMarks(StudentMarks marks, Long id) {
		CommonResponse response = null;
		try {
			int rs = jdbc.update("UPDATE student_marks set c =" + marks.getC() + ", java=" + marks.getJava()
					+ ", linux=" + marks.getLinux() + ", python=" + marks.getPython() + " where id =" + id);
			if (rs > 0) {
				response = new CommonResponse();
				response.setResponse("Successfully updated marks ");
				response.setId(id);
			}
		} catch (Exception e) {
			System.out.println(e + " while adding error");
		}
		return response;
	}

	@Override
	public String deleteMarks(Long id) {

		return null;
	}

/*	public static void main(String[] args) {
		StudentMarks sm = new StudentMarks();
		sm.setId(12L);
		sm.setC(213);
		StudentMarksDaoImpl smd = new StudentMarksDaoImpl();
		smd.addMarks(sm);
	}
*/
	@Override
	public StudentMarks getMarksById(Long id) {
		
		return marksrepo.findOne(id);
	}

}
