package com.student.results.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.student.results.common.CommonResponse;
import com.student.results.common.StudentResponse;
import com.student.results.model.Register;
import com.student.results.model.StudentMarks;
import com.student.results.repository.MarksRepository;
import com.student.results.repository.RegisterRepository;

@Service
public class RegisterDaoImpl implements RegisterDao {

	private static final Logger LOGGER=LoggerFactory.getLogger(RegisterDaoImpl.class);
	
	@Autowired
	RegisterRepository registerRepository;
	
	@Autowired
	MarksRepository marksRepository;

	@Override
	public CommonResponse insert(Register register) {
		
		CommonResponse response=null;
		StudentMarks studentMarks=null;
		try{
			studentMarks=new StudentMarks();
			Register student=registerRepository.save(register);
			studentMarks.setId(student.getId());
			studentMarks.setName(register.getName());
			studentMarks=marksRepository.save(studentMarks);
	if(student!=null && studentMarks!=null){
		response=new CommonResponse();
		response.setId(student.getId());
		response.setResponse("successfully inserted");
	}	
		}
		catch(Exception exception){
		   LOGGER.error("Error while inserting"+exception.getMessage());
		   exception.printStackTrace();
		}
		return response;
	}

	@Override
	public Register findById(Long sid) {
		Register student=null;
		try{
			student=new Register();
			 student=registerRepository.findOne(sid);
		}
		catch(Exception exception){
			LOGGER.error("error while retrieving student by Id"+exception.getMessage());
			exception.printStackTrace();
		}
		return student;
	}

	@Override
	public StudentResponse findAll() {
		StudentResponse response=null;
		List<Register> students=null;
		Integer count=0;
		try{
			students=new ArrayList<Register>();
			students=registerRepository.findAll();
			System.out.println(students);
		    count=students.size();
			response=new StudentResponse();
			response.setStudents(students);
			response.setCount(count);
		}
		catch(Exception exception){
			LOGGER.error("error while retrieving all students"+exception.getMessage());
			exception.printStackTrace();
		}
		return response;
	}

	@Override
	public CommonResponse delete(Long sid) {
		CommonResponse response=null;
		try{
			registerRepository.delete(sid);
			marksRepository.delete(sid);
			response=new CommonResponse();
			response.setId(sid);
			response.setResponse("successfully deleted");
		}
		catch(Exception exception){
			LOGGER.error("error while deleting student by Id"+exception.getMessage());
			exception.printStackTrace();
		}
		return response;
	}

	@Override
	public CommonResponse update(Long sid, Register register) {
		CommonResponse response=null;
		Register student=null;
		try{
			 student=new Register();
			 student=registerRepository.findOne(sid);
			student.setPassword(register.getPassword());
			student.setName(register.getName());
			student.setDob(register.getDob());
			student.setBranch(register.getBranch());
			student.setAddress(register.getAddress());
			student=registerRepository.save(student);
			if(student!=null){
				response=new CommonResponse();
				response.setId(sid);
				response.setResponse("successfully updated");
		}
		}
		catch(Exception exception){
			LOGGER.error("error while updating student by Id"+exception.getMessage());
			exception.printStackTrace();
		}
		return response;
	}
	
	
	
}
