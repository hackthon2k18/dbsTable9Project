package com.springboot.dbshackathon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.dbshackathon.dao.LoginDao;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDao loginDao;

	@Override
	public String validateLoginMember(String email, String pwd) {

		return loginDao.validateLoginMember(email, pwd);
	}

}
