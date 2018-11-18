package com.student.results.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.student.results.common.CommonResponse;
import com.student.results.common.StudentResponse;
import com.student.results.common.UriConstants;
import com.student.results.model.Register;
import com.student.results.service.RegisterService;

@Api(value = "StudentRegistration", description = "Register APIs")
@RestController
@RequestMapping(value = "/" + UriConstants.REGISTER)
public class RegisterController {

	private static final Logger LOGGER = LoggerFactory.getLogger(RegisterController.class);
	@Autowired
	RegisterService service;

	@ApiOperation(value = "Register Student", position = 1)
	@ApiResponse(code = 200, message = "Successfully added student")
	@RequestMapping(value = UriConstants.INSERT, method = RequestMethod.POST)
	public CommonResponse addStudent(@RequestBody Register student) {
		CommonResponse response = null;
		try {
			response = service.insert(student);
		} catch (Exception exception) {
			LOGGER.error("Add Student request handled Successfully" + exception.getMessage());
			exception.printStackTrace();
		}
		return response;

	}

	@ApiOperation(value = "find Student by Id", position = 2)
	@ApiResponse(code = 200, message = "Successfully find student by Id")
	@RequestMapping(value = UriConstants.FINDBYID + "/{studentId}", method = RequestMethod.GET)
	public Register getStudent(@PathVariable(value = "studentId") Long studentId) {
		Register student = null;
		try {
			student=new Register();
			student = service.findById(studentId);
		} catch (Exception exception) {
			LOGGER.error("Find Student request handled Successfully" + exception.getMessage());
			exception.printStackTrace();
		}
		return student;

	}
	
	@ApiOperation(value = "findAll Students", position = 3)
	@ApiResponse(code = 200, message = "Successfully find All students ")
	@RequestMapping(value = UriConstants.FINDALL, method = RequestMethod.GET)
	public ResponseEntity<StudentResponse> getStudents() {
		StudentResponse response=null;
		try {
			response = service.findAll();
			return new ResponseEntity<StudentResponse>(response, HttpStatus.OK);
		} catch (Exception exception) {
			LOGGER.error("Find AllStudents request handled Successfully" + exception.getMessage());
			exception.printStackTrace();
			return null;
		}
		

	}
	
	@ApiOperation(value = "update Student by Id", position = 4)
	@ApiResponse(code = 200, message = "Successfully updated student by Id")
	@RequestMapping(value = UriConstants.UPDATE + "/{studentId}", method = RequestMethod.PUT)
	public CommonResponse updateStudent(@PathVariable(value = "studentId") Long studentId,@RequestBody Register student) {
		CommonResponse response = null;
		System.out.println("i am in controller");
		try {
			response= service.update(studentId, student);
		} catch (Exception exception) {
			LOGGER.error("update Student request handled Successfully" + exception.getMessage());
			exception.printStackTrace();
		}
		return response;

	}
	
	@ApiOperation(value = "delete Student by Id", position = 5)
	@ApiResponse(code = 200, message = "Successfully deleted student by Id")
	@RequestMapping(value = UriConstants.DELETE + "/{studentId}", method = RequestMethod.DELETE)
	public CommonResponse deleteStudent(@PathVariable(value = "studentId") Long studentId) {
		CommonResponse response = null;
		try {
			response= service.delete(studentId);
		} catch (Exception exception) {
			LOGGER.error("delete Student request handled Successfully" + exception.getMessage());
			exception.printStackTrace();
		}
		return response;

	}
}