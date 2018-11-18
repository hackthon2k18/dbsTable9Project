package com.springboot.DbsHackthon.dao;

import com.springboot.DbsHackthon.common.CommonResponse;
import com.springboot.DbsHackthon.common.StudentResponse;
import com.springboot.DbsHackthon.model.Register;

public interface RegisterDao {

	public CommonResponse insert(Register register);

	public Register findById(Long sid);

	public StudentResponse findAll();

	public CommonResponse delete(Long sid);

	public CommonResponse update(Long sid, Register register);
}
