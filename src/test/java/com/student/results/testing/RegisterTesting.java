package com.student.results.testing;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.student.results.common.CommonResponse;
import com.student.results.common.StudentResponse;
import com.student.results.dao.RegisterDaoImpl;
import com.student.results.model.Register;
import com.student.results.service.RegisterServiceImpl;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(MockitoJUnitRunner.class)
public class RegisterTesting {

	@Mock
	RegisterDaoImpl registerDao;
	
	@InjectMocks
	RegisterServiceImpl registerService;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testA_findAll(){
		List<Register> students=new ArrayList<Register>();
		students.add(new Register(1L,"abc","abc","cse",new Date(),"hyd"));
		students.add(new Register(2L,"def","def","It",new Date(),"kmm"));
		StudentResponse response=new StudentResponse();
		response.setStudents(students);
		response.setCount(students.size());
		when(registerService.findAll()).thenReturn(response);
		response=registerService.findAll();
		System.out.println(response.getCount());
        assertEquals(2, (long)response.getCount());
	}
	
	@Test
	public void testB_findById(){
		Register register=new Register(1L,"abc","abc","cse",new Date(),"hyd");
		when(registerService.findById(1L)).thenReturn(register);
		Register student=registerService.findById(1L);
		System.out.println(student);
		assertEquals(1L, (long)student.getId());
		assertEquals("abc", student.getName());
		assertEquals("abc", student.getPassword());
		assertEquals("cse", student.getBranch());
		assertEquals("hyd", student.getAddress());
		
	}
	
	@Test
	public void testC_save(){
		
		Register register=new Register(1L,"abc","abc","cse",new Date(),"hyd");
		CommonResponse response=new CommonResponse();
		response.setId(1L);
		when(registerService.insert(register)).thenReturn(response);
		CommonResponse res=registerService.insert(register);
		assertEquals(1L, (long)res.getId());
		
	}
	
	@Test
	public void testD_update(){
		Register register=new Register(1L,"abc","abc","cse",new Date(),"hyd");
		CommonResponse response=new CommonResponse();
		response.setId(1L);
		when(registerService.update(1L,register)).thenReturn(response);
		CommonResponse res=registerService.update(1L,register);
		assertEquals(1L, (long)res.getId());
	}

	@Test
	public void testE_delete(){
		Register register=new Register(1L,"abc","abc","cse",new Date(),"hyd");
		CommonResponse response=new CommonResponse();
		response.setId(1L);
		when(registerService.delete(1L)).thenReturn(response);
		CommonResponse res=registerService.delete(1L);
		assertEquals(1L, (long)res.getId());
	}
}
