package com.student.results.dao;

import com.student.results.common.CommonResponse;
import com.student.results.common.StudentResponse;
import com.student.results.model.Register;

public interface RegisterDao {

	public CommonResponse insert(Register register);

	public Register findById(Long sid);

	public StudentResponse findAll();

	public CommonResponse delete(Long sid);

	public CommonResponse update(Long sid, Register register);
}
