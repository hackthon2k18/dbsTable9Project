package com.springboot.dbshackathon.service;

import com.springboot.dbshackathon.common.CommonResponse;
import com.springboot.dbshackathon.model.Register;

public interface RegisterService {

	public CommonResponse insert(Register register);

	public Register findById(Long sid);

	// public UserResponse findAll();

	public CommonResponse delete(Long sid);

	public CommonResponse update(Long sid, Register register);
}
