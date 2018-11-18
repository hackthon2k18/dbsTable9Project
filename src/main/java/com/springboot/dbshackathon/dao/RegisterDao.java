package com.springboot.dbshackathon.dao;

import com.springboot.dbshackathon.common.CommonResponse;
import com.springboot.dbshackathon.common.StudentResponse;
import com.springboot.dbshackathon.model.Register;

public interface RegisterDao {

	public CommonResponse insert(Register register);

	public Register findById(Long sid);

	public StudentResponse findAll();

	public CommonResponse delete(Long sid);

	public CommonResponse update(Long sid, Register register);
}
