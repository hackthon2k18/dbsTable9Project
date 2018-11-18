package com.student.results.testing;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springboot.DbsHackthon.common.CommonResponse;
import com.springboot.DbsHackthon.dao.StudentMarksDaoImpl;
import com.springboot.DbsHackthon.model.StudentMarks;
import com.springboot.DbsHackthon.service.StudentMarksServiceImpl;
import com.student.results.StudentResultsApplicationTests;
@RunWith(SpringJUnit4ClassRunner.class)
public class MarksTesting extends StudentResultsApplicationTests{

	@Mock
	private StudentMarksDaoImpl studentMarksDaoImpl;
	
	@InjectMocks
	private StudentMarksServiceImpl service;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	public static CommonResponse response = null;
	
	@Test
	public void getMarksTest(){
		List<StudentMarks> list = new ArrayList<StudentMarks>();
		list.add(new StudentMarks(1l,"vamsi",89,89,75,78));
		list.add(new StudentMarks(2l,"vasi",89,57,288,555));
		list.add(new StudentMarks(3l,"vsi",89,8,9,2));
		when(studentMarksDaoImpl.getMarks()).thenReturn(list);
		
		List<StudentMarks> res = service.getMarks();
		
		assertEquals(3, res.size());
	}
	
	@Test
	public void updateMarksTest(){
		StudentMarks marks = new StudentMarks(1l,"vamsi",88,89,8,5);
		CommonResponse response=new CommonResponse();
		response.setResponse("Successfully updated marks 1");
		when(studentMarksDaoImpl.updateMarks(marks, 1l)).thenReturn(response);	
		
		CommonResponse res = service.updateMarks(marks, 1l);
		assertEquals("Successfully updated marks 1", res.getResponse());
	}
	
}
