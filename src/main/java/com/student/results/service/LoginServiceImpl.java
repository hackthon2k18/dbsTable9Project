package com.student.results.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.results.dao.LoginDao;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDao loginDao;

	@Override
	public String validateLoginMember(Long id, String pwd) {

		return loginDao.validateLoginMember(id, pwd);
	}

}
