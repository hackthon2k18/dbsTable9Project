package com.springboot.DbsHackthon.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.DbsHackthon.common.CommonResponse;
import com.springboot.DbsHackthon.model.HtmlToJson;
import com.springboot.DbsHackthon.model.StudentMarks;
import com.springboot.DbsHackthon.service.HtmlToJsonPareserService;
import com.springboot.DbsHackthon.service.StudentMarksService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@Api(value = "Student marks", description = "Student marks API")
@RestController
@RequestMapping(value = "/marks")
public class StudentMarksController {

	@Autowired
	private StudentMarksService marksService;
	
	@Autowired
	private HtmlToJsonPareserService html;

	@ApiOperation(value = "Add marks", position = 1)
	@ApiResponse(code = 200, message = "Successfully added marks")
	@PutMapping("/update/{id}")
	public ResponseEntity<CommonResponse> updateMarks(@PathVariable Long id, @RequestBody @Valid StudentMarks studentmarks) {
		CommonResponse response = null;
		try {
			response = marksService.updateMarks(studentmarks, id);
			System.out.println("add marks");
			return new ResponseEntity<CommonResponse>(response, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<CommonResponse>(response, HttpStatus.OK);
		}

	}

	@ApiOperation(value = "Get marks", position = 2)
	@ApiResponse(code = 200, message = "Successfully get marks")
	@GetMapping("/getallmarks")
	public ResponseEntity<List<StudentMarks>> getAll() {
		List<StudentMarks> response = null;
		try {
			response = marksService.getMarks();
			return new ResponseEntity<List<StudentMarks>>(response, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<List<StudentMarks>>(response, HttpStatus.OK);
		}

	}
	
	@ApiOperation(value = "Get marks by id", position = 3)
	@ApiResponse(code = 200, message = "Successfully get marks by id")
	@GetMapping("/getone/{id}")
	public ResponseEntity<StudentMarks> getOne(@PathVariable Long id) {
		StudentMarks response = null;
		try {
			response = marksService.getMarksById(id);
			return new ResponseEntity<StudentMarks>(response, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<StudentMarks>(response, HttpStatus.OK);
		}

	}
	
	@ApiOperation(value = "Get json request", position = 4)
	@ApiResponse(code = 200, message = "Successfully get json")
	@PostMapping("convert")
	public ResponseEntity<StringBuilder> convert(@RequestBody @Valid HtmlToJson json) {
		try {
			
			StringBuilder response = html.convert2json(json);
			return new ResponseEntity<StringBuilder>(response,HttpStatus.OK);
		
		} catch (Exception e) {
			System.out.println("Encountered issue while converting to pojo: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
}
