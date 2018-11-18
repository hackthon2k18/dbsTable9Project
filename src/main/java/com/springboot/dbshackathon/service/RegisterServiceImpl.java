package com.springboot.dbshackathon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.dbshackathon.common.CommonResponse;
import com.springboot.dbshackathon.dao.RegisterDao;
import com.springboot.dbshackathon.model.Register;

@Service
public class RegisterServiceImpl implements RegisterService {
	@Autowired
	RegisterDao registerDao;

	@Override
	public CommonResponse insert(Register register) {
		CommonResponse response = null;
		response = registerDao.insert(register);
		return response;
	}

	@Override
	public Register findById(Long sid) {
		Register register = null;
		register = registerDao.findById(sid);
		return register;

	}

	// @Override
	// public StudentResponse findAll() {
	// StudentResponse response=new StudentResponse();
	// response=registerDao.findAll();
	// return response;
	//
	// }

	@Override
	public CommonResponse delete(Long sid) {
		CommonResponse response = null;
		response = registerDao.delete(sid);
		return response;
	}

	@Override
	public CommonResponse update(Long sid, Register register) {
		CommonResponse response = null;
		response = registerDao.update(sid, register);
		return response;
	}

}
