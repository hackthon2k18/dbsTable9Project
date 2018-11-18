package com.student.results.service;


import com.student.results.common.CommonResponse;
import com.student.results.common.StudentResponse;
import com.student.results.model.Register;


public interface RegisterService {

	public CommonResponse insert(Register register);

	public Register findById(Long sid);

	public StudentResponse findAll();

	public CommonResponse delete(Long sid);

	public CommonResponse update(Long sid, Register register);
}
